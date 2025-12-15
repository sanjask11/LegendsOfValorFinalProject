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

    // -------- Java 8 compatible (no switch expression) --------
    private static boolean isAccessible(LoVTileType t) {
        switch (t) {
            case WALL:
            case INACCESSIBLE:
            case OBSTACLE:
                return false;
            default:
                return true;
        }
    }

    @Override
    public LoVTileType getType() {
        return type;
    }

    // -------- Java 8 compatible symbol switch --------
    @Override
    public char getSymbol() {
        switch (type) {
            case NEXUS:
                return 'N';
            case INACCESSIBLE:
                return 'I';
            case OBSTACLE:
                return 'O';
            case BUSH:
                return 'B';
            case CAVE:
                return 'C';
            case KOULOU:
                return 'K';
            case PLAIN:
                return '.';
            case WALL:
                return 'X';
            default:
                return '?';
        }
    }

    /**
     * 3-character colored block used by the pretty map display.
     * If your terminal doesn't support ANSI colors, it will still show as spaces.
     */
    public String bgBlock() {
        String block = "   ";

        switch (type) {
            case NEXUS:
                return BLUE_BG + block + RESET;
            case WALL:
                return GRAY_BG + block + RESET;
            case INACCESSIBLE:
                return GRAY_BG + block + RESET;
            case BUSH:
                return GREEN_BG + block + RESET;
            case CAVE:
                return MAGENTA_BG + block + RESET;
            case KOULOU:
                return YELLOW_BG + block + RESET;
            case PLAIN:
                return CYAN_BG + block + RESET;
            case OBSTACLE:
                return OBSTACLE_BG + block + RESET;
            default:
                return block;
        }
    }
}
