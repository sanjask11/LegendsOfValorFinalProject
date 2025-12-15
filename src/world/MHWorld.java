package world;

import core.Direction;
import entities.heroes.Hero;
import market.Market;
import world.party.Party;
import world.tiles.CommonTile;
import world.tiles.InaccessibleTile;
import world.tiles.MarketTile;
import world.tiles.Tile;

import java.io.Serializable;
import java.util.Random;
/*
 MHWorld: Monsters & Heroes world map implementation.
 Generates a random grid with common/market/inaccessible tiles and tracks party position.
 */
public class MHWorld extends AbstractWorld implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Party party;

    public MHWorld(int size, Party party) {
        super(size, size); // sets rows, cols, allocates grid[]
        this.party = party;

        generateWorld();
        placeParty();
    }

    @Override
    protected void generateWorld() {
        Random rand = new Random();

        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                double x = rand.nextDouble();

                if (x < 0.20) {
                    grid[r][c] = new InaccessibleTile();
                } else if (x < 0.50) {
                    grid[r][c] = new MarketTile(new Market());
                } else {
                    grid[r][c] = new CommonTile();
                }
            }
        }
    }

    private void placeParty() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {
                if (grid[r][c].isAccessible()) {
                    party.setPosition(r, c);
                    return;
                }
            }
        }
    }

    public boolean moveParty(Direction dir) {
        int r = party.getRow();
        int c = party.getCol();


        switch (dir) {
            case UP:
                r--;
                break;
            case DOWN:
                r++;
                break;
            case LEFT:
                c--;
                break;
            case RIGHT:
                c++;
                break;
            default:
                break;
        }

        if (!inBounds(r, c)) {
            System.out.println("You cannot move outside the map!");
            return false;
        }

        if (!grid[r][c].isAccessible()) {
            System.out.println("Blocked. This tile is inaccessible.");
            return false;
        }

        party.setPosition(r, c);
        return true;
    }

    @Override
    public void display() {
        final String RESET = "\u001B[0m";
        final String RED = "\u001B[31m";
        final String GREEN = "\u001B[32m";
        final String BLUE = "\u001B[34m";
        final String YELLOW = "\u001B[33m";

        int pr = party.getRow();
        int pc = party.getCol();

        int totalWidth = cols * 5;
        String title = " WORLD MAP ";
        int pad = (totalWidth - title.length()) / 2;

        System.out.println();

        // Java 8 has no String.repeat()
        System.out.println(repeat(" ", pad) + title);
        System.out.println();

        for (int r = 0; r < rows; r++) {

            System.out.print("  ");
            for (int c = 0; c < cols; c++) {
                System.out.print("╭───╮ ");
            }
            System.out.println();

            System.out.print("  ");
            for (int c = 0; c < cols; c++) {
                char symbol = (r == pr && c == pc) ? 'P' : grid[r][c].getSymbol();
                String colored;

                // Java 8 compatible switch (no "->")
                switch (symbol) {
                    case 'P':
                        colored = YELLOW + "P" + RESET;
                        break;
                    case 'X':
                        colored = RED + "X" + RESET;
                        break;
                    case 'M':
                        colored = BLUE + "M" + RESET;
                        break;
                    case '.':
                        colored = GREEN + "." + RESET;
                        break;
                    default:
                        colored = "" + symbol;
                        break;
                }

                System.out.print("│ " + colored + " │ ");
            }
            System.out.println();

            System.out.print("  ");
            for (int c = 0; c < cols; c++) {
                System.out.print("╰───╯ ");
            }
            System.out.println();
        }

        System.out.println("\n=== LEGEND ===");
        System.out.println(YELLOW + "P" + RESET + " : Party (You)");
        System.out.println(RED + "X" + RESET + " : Inaccessible");
        System.out.println(BLUE + "M" + RESET + " : Market");
        System.out.println(GREEN + "." + RESET + " : Common Tile");
        System.out.println();

        System.out.println("=== PARTY STATUS ===");
        for (Hero h : party.getHeroes()) {
            System.out.println(
                    h.getName()
                            + "  HP: " + h.getHp()
                            + "  MP: " + h.getMp()
                            + "  STR:" + h.getStrength()
                            + "  DEX:" + h.getDexterity()
                            + "  AGI:" + h.getAgility()
                            + "  LVL:" + h.getLevel()
            );
        }
        System.out.println();
    }

    // Java 8 replacement for String.repeat()
    private static String repeat(String s, int n) {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) sb.append(s);
        return sb.toString();
    }

    public Tile getCurrentTile() {
        return grid[party.getRow()][party.getCol()];
    }
}
