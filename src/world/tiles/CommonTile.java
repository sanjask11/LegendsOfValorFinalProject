package world.tiles;
/*
 CommonTile: a normal, walkable tile with no special effects.
 */
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

