package world.tiles;

public class CommonTile extends Tile {
    private static final long serialVersionUID = 1L;

    public CommonTile() {
        super(true);
    }

    @Override
    public char getSymbol() {
        return '.';
    }
}

