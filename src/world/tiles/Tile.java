package world.tiles;

import java.io.Serializable;

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

