package world;

import core.Direction;
import world.tiles.LoVTile;
import world.tiles.LoVTileType;
import world.tiles.Tile;

import java.io.Serializable;

public class LoVWorld extends AbstractWorld implements Serializable {

    public static final int SIZE = 8;

    // Track three heroes
    private final int[] heroRow = new int[3];
    private final int[] heroCol = new int[3];

    public LoVWorld() {
        super(SIZE, SIZE);
        generateWorld();
        placeHeroesAtNexus();
    }

    @Override
    protected void generateWorld() {

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // vertical walls
                if (c == 2 || c == 5) {
                    grid[r][c] = new LoVTile(LoVTileType.WALL);
                    continue;
                }

                // nexus rows (top + bottom)
                if (r == 0 || r == rows - 1) {
                    grid[r][c] = new LoVTile(LoVTileType.NEXUS);
                    continue;
                }

                // random terrain
                double x = Math.random();

                if (x < 0.20) grid[r][c] = new LoVTile(LoVTileType.BUSH);
                else if (x < 0.40) grid[r][c] = new LoVTile(LoVTileType.CAVE);
                else if (x < 0.60) grid[r][c] = new LoVTile(LoVTileType.KOULOU);
                else grid[r][c] = new LoVTile(LoVTileType.PLAIN);
            }
        }
    }

    private void placeHeroesAtNexus() {
        heroRow[0] = rows - 1; heroCol[0] = 0; // left lane
        heroRow[1] = rows - 1; heroCol[1] = 3; // mid lane
        heroRow[2] = rows - 1; heroCol[2] = 6; // right lane
    }

    private boolean sameLane(int colA, int colB) {
        return laneOf(colA) == laneOf(colB);
    }

    private int laneOf(int col) {
        if (col <= 1) return 0;
        if (col <= 4) return 1;
        return 2;
    }

    public Tile getTileForHero(int idx) {
        return grid[heroRow[idx]][heroCol[idx]];
    }

    public boolean moveHero(int idx, Direction d) {
        int r = heroRow[idx];
        int c = heroCol[idx];

        int nr = r, nc = c;

        switch (d) {
            case UP -> nr--;
            case DOWN -> nr++;
            case LEFT -> nc--;
            case RIGHT -> nc++;
        }

        if (!inBounds(nr, nc)) return false;

        // --- FIXED TYPO HERE ---
        if (grid[nr][nc].getType() == LoVTileType.WALL) return false;

        if (!sameLane(c, nc)) return false;

        for (int i = 0; i < 3; i++) {
            if (i != idx && heroRow[i] == nr && heroCol[i] == nc)
                return false;
        }

        heroRow[idx] = nr;
        heroCol[idx] = nc;
        return true;
    }


    public boolean teleportHero(int idx, int r, int c) {
        if (!inBounds(r, c)) return false;
        if (grid[r][c].getType() == LoVTileType.WALL) return false;

        for (int i = 0; i < 3; i++) {
            if (i != idx && heroRow[i] == r && heroCol[i] == c)
                return false;
        }

        heroRow[idx] = r;
        heroCol[idx] = c;
        return true;
    }

    public boolean recallHero(int idx) {
        heroRow[idx] = rows - 1;

        switch (idx) {
            case 0 -> heroCol[idx] = 0;
            case 1 -> heroCol[idx] = 3;
            case 2 -> heroCol[idx] = 6;
        }
        return true;
    }

    @Override
    public void display() {
        System.out.println("\n=== LEGENDS OF VALOR MAP ===\n");

        for (int r = 0; r < rows; r++) {

            // top border
            for (int c = 0; c < cols; c++) {
                System.out.print("╭───╮ ");
            }
            System.out.println();

            // symbols
            for (int c = 0; c < cols; c++) {
                char sym = grid[r][c].getSymbol();

                // draw heroes
                for (int h = 0; h < 3; h++) {
                    if (heroRow[h] == r && heroCol[h] == c)
                        sym = (char) ('0' + h);  // hero 0,1,2
                }

                System.out.print("│ " + sym + " │ ");
            }
            System.out.println();

            // bottom border
            for (int c = 0; c < cols; c++) {
                System.out.print("╰───╯ ");
            }
            System.out.println();
        }

        System.out.println("\nLegend:");
        System.out.println("0/1/2 = Heroes");
        System.out.println("N = Nexus");
        System.out.println("X = Wall");
        System.out.println("B = Bush");
        System.out.println("C = Cave");
        System.out.println("K = Koulou");
        System.out.println(". = Plain\n");
    }
}
