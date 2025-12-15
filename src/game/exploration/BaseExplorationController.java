package game.exploration;

import core.GameState;
import core.PauseMenu;
import core.SaveManager;
import game.InventoryMenu;

import java.util.Scanner;

/**
 * Shared exploration controller used by MH and LoV.
 * The game-specific subclass only handles commands unique to MH/LoV.
 */
public abstract class BaseExplorationController {

    protected final Scanner in;
    protected final ExplorationLogicBase logic;
    protected final ExplorationUIBase ui;

    private static final String DEFAULT_SAVE_FILE = "savegame.dat";

    protected BaseExplorationController(Scanner in,
                                        ExplorationLogicBase logic,
                                        ExplorationUIBase ui) {
        this.in = in;
        this.logic = logic;
        this.ui = ui;
    }

    public void run() {
        while (true) {
            ui.printMainPrompt();
            String choice = in.nextLine().trim().toUpperCase();

            // Game-specific command handled by child classes first
            if (handleGameSpecificCommand(choice)) continue;

            // Common commands (Java 8 compatible switch)
            switch (choice) {
                case "I":
                    ui.printPartyInfo(logic.getParty().getHeroes());
                    break;

                case "B":
                    new InventoryMenu(in, logic.getParty()).show();
                    break;

                case "V":
                    saveGame();
                    break;

                case "L":
                    loadGame();
                    break;

                case "P":
                    pauseGame();
                    break;

                case "Q":
                    ui.printGoodbye();
                    return;

                default:
                    ui.printInvalidInput();
                    break;
            }
        }
    }

    /** Subclass overrides for W/A/S/D etc. */
    protected abstract boolean handleGameSpecificCommand(String cmd);

    /* COMMON FUNCTIONALITY — SHARED BETWEEN MH & LoV */

    protected void saveGame() {
        GameState state = new GameState(
                logic.getWorld(),
                logic.getParty()
        );
        SaveManager.save(state, DEFAULT_SAVE_FILE);
    }

    protected void loadGame() {
        GameState state = SaveManager.load(DEFAULT_SAVE_FILE);
        if (state == null) return;
        System.out.println("Game restored.");
        state.getWorld().display();
    }

    protected void pauseGame() {
        try {
            PauseMenu.show(in, new Runnable() {
                @Override
                public void run() {
                    saveGame();
                }
            });
            // (Java 8 also supports: PauseMenu.show(in, this::saveGame); but this is safest everywhere)
        } catch (RuntimeException ex) {
            if ("QUIT_TO_MENU".equals(ex.getMessage())) return;
            throw ex;
        }
    }
}
