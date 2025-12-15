package world.tiles;
/*
 InaccessibleTile: an impassable tile that heroes and monsters cannot enter.
 */
public class InaccessibleTile extends Tile {
    private static final long serialVersionUID = 1L;

    public InaccessibleTile() {
        super(false);
    }

    @Override
    public char getSymbol() {
        return 'X';
    }
}

