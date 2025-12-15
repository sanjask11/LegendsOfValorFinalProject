package world.tiles;

import java.io.Serializable;
/*
 Tile: base class for all map tiles in the LoV world.
 Stores accessibility and defines common tile behavior.
 */
public abstract class Tile implements Serializable {
    private static final long serialVersionUID = 1L;

    private final boolean accessible;

    protected Tile(boolean accessible) {
        this.accessible = accessible;
    }

    public boolean isAccessible() {
        return accessible;
    }

    public LoVTileType getType() {
        return null;
    }


    public abstract char getSymbol();
}

