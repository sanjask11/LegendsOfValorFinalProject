package game.exploration;

import core.Direction;
import world.LoVWorld;
import world.party.Party;

import java.util.Scanner;

public class LoVExplorationController extends BaseExplorationController {

    private final LoVExplorationLogic logic;
    private final LoVExplorationUI uiConcrete;

    public LoVExplorationController(Scanner in, LoVWorld world, Party party) {
        super(
                in,
                new LoVExplorationLogic(world, party),
                new LoVExplorationUI()
        );

        this.logic = (LoVExplorationLogic) super.logic;
        this.uiConcrete = (LoVExplorationUI) super.ui;
    }

    @Override
    protected boolean handleGameSpecificCommand(String c) {

        switch (c) {

            case "W", "A", "S", "D" -> {
                int hero = askHeroIndex();
                Direction d = keyToDirection(c);
                move(hero, d);
                uiConcrete.displayWorld(logic.getWorld());
                return true;
            }

            case "T" -> {
                teleport();
                uiConcrete.displayWorld(logic.getWorld());
                return true;
            }

            case "R" -> {
                recall();
                uiConcrete.displayWorld(logic.getWorld());
                return true;
            }

            default -> { return false; }
        }
    }

    private int askHeroIndex() {
        System.out.print("Choose hero (0,1,2): ");
        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx < 0 || idx > 2) throw new Exception();
            return idx;
        } catch (Exception e) {
            System.out.println("Invalid hero index.");
            return askHeroIndex();
        }
    }

    private Direction keyToDirection(String c) {
        return switch (c) {
            case "W" -> Direction.UP;
            case "A" -> Direction.LEFT;
            case "S" -> Direction.DOWN;
            case "D" -> Direction.RIGHT;
            default -> null;
        };
    }

    private void move(int heroIndex, Direction dir) {
        if (!logic.move(heroIndex, dir)) {
            System.out.println("Invalid move.");
        }
    }

    private void teleport() {
        uiConcrete.printTeleportPrompt();
        try {
            String[] parts = in.nextLine().trim().split(" ");
            int idx = Integer.parseInt(parts[0]);
            int r = Integer.parseInt(parts[1]);
            int c = Integer.parseInt(parts[2]);
            logic.teleport(idx, r, c);
        } catch (Exception ignored) {}
    }

    private void recall() {
        uiConcrete.printRecallPrompt();
        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            logic.recall(idx);
        } catch (Exception ignored) {}
    }
}
