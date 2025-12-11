package world.tiles;

import world.tiles.Tile;

public class LoVTile extends Tile {

    private final LoVTileType type;

    public LoVTile(LoVTileType type) {
        super(type != LoVTileType.WALL); // wall = inaccessible
        this.type = type;
    }

    @Override
    public LoVTileType getType() {
        return type;
    }

    @Override
    public char getSymbol() {
        return switch (type) {
            case NEXUS -> 'N';
            case BUSH -> 'B';
            case CAVE -> 'C';
            case KOULOU -> 'K';
            case PLAIN -> '.';
            case WALL -> 'X';
        };
    }



}
