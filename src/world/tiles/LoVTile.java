package world.tiles;

public class LoVTile extends Tile {

    // ANSI colors (works in most terminals)
    private static final String RESET = "\u001B[0m";

    private static final String BLUE_BG     = "\u001B[44m";
    private static final String GREEN_BG    = "\u001B[42m";
    private static final String YELLOW_BG   = "\u001B[43m";
    private static final String MAGENTA_BG  = "\u001B[45m";
    private static final String CYAN_BG     = "\u001B[46m";
    private static final String GRAY_BG     = "\u001B[100m";
    private static final String OBSTACLE_BG = "\u001B[48;5;94m";

    private final LoVTileType type;

    public LoVTile(LoVTileType type) {
        super(isAccessible(type));
        this.type = type;
    }

    private static boolean isAccessible(LoVTileType t) {
        return switch (t) {
            case WALL, INACCESSIBLE, OBSTACLE -> false;
            default -> true;
        };
    }

    @Override
    public LoVTileType getType() {
        return type;
    }

    @Override
    public char getSymbol() {
        return switch (type) {
            case NEXUS -> 'N';
            case INACCESSIBLE -> 'I';
            case OBSTACLE -> 'O';
            case BUSH -> 'B';
            case CAVE -> 'C';
            case KOULOU -> 'K';
            case PLAIN -> '.';
            case WALL -> 'X';
        };
    }

    /**
     * 3-character colored block used by the pretty map display.
     * If your terminal doesn't support ANSI colors, it will still show as spaces.
     */
    public String bgBlock() {
        String block = "   ";

        return switch (type) {
            case NEXUS        -> BLUE_BG     + block + RESET;
            case WALL         -> GRAY_BG     + block + RESET;
            case INACCESSIBLE -> GRAY_BG     + block + RESET;
            case BUSH         -> GREEN_BG    + block + RESET;
            case CAVE         -> MAGENTA_BG  + block + RESET;
            case KOULOU       -> YELLOW_BG   + block + RESET;
            case PLAIN        -> CYAN_BG     + block + RESET;
            case OBSTACLE     -> OBSTACLE_BG + block + RESET;
        };
    }
}
