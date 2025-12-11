package world;

import world.tiles.Tile;

import java.io.Serializable;

/**
 * Base class for all grid-based worlds (MH and LoV).
 * Holds the grid and shared helpers; concrete worlds define
 * how the grid is generated and how it is displayed.
 */
public abstract class AbstractWorld implements Serializable {
    private static final long serialVersionUID = 1L;

    // Common world geometry
    protected final int rows;
    protected final int cols;

    // Shared grid structure
    protected final Tile[][] grid;

    /**
     * Construct a world with fixed rows/cols and allocate the grid.
     * Subclasses will fill in the grid in generateWorld().
     */
    protected AbstractWorld(int rows, int cols) {
        this.rows = rows;
        this.cols = cols;
        this.grid = new Tile[rows][cols];
    }

    /** Subclasses must create and place all tiles here. */
    protected abstract void generateWorld();

    /** Subclasses define how the world is rendered to the terminal. */
    public abstract void display();

    /** Check whether (r, c) lies inside the world bounds. */
    protected boolean inBounds(int r, int c) {
        return r >= 0 && r < rows && c >= 0 && c < cols;
    }

    /** Direct access to a tile at a given position. */
    public Tile getTile(int r, int c) {
        return grid[r][c];
    }

    public int getRows() {
        return rows;
    }

    public int getCols() {
        return cols;
    }
}
