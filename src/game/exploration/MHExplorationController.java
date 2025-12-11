package game.exploration;

import core.Direction;
import entities.heroes.Hero;
import entities.monsters.Monster;
import entities.monsters.MonsterFactory;
import game.InventoryMenu;
import game.battle.Battle;
import world.MHWorld;
import world.party.Party;
import world.tiles.MarketTile;
import world.tiles.Tile;

import java.util.List;
import java.util.Random;
import java.util.Scanner;

/*
 * MH exploration:
 * - Interprets movement commands (W/A/S/D)
 * - Triggers UI updates (world redraw, animations)
 * - Handles market entry
 * - Triggers battles on common tiles
 *
 * Shared commands (I, B, V, L, P, Q) are handled in BaseExplorationController.
 */
public class MHExplorationController extends BaseExplorationController {

    private final MHExplorationLogic mhLogic;
    private final MHExplorationUI mhUI;
    private final MonsterFactory monsterFactory;
    private final Random rng;

    public MHExplorationController(Scanner in,
                                   MHWorld world,
                                   Party party,
                                   MonsterFactory monsterFactory,
                                   Random rng) {
        super(
                in,
                new MHExplorationLogic(world, party, monsterFactory, rng),
                new MHExplorationUI()
        );
        this.mhLogic = (MHExplorationLogic) this.logic;
        this.mhUI = (MHExplorationUI) this.ui;
        this.monsterFactory = monsterFactory;
        this.rng = rng;
    }

    @Override
    protected boolean handleGameSpecificCommand(String choice) {
        switch (choice) {
            case "W" -> move(Direction.UP);
            case "A" -> move(Direction.LEFT);
            case "S" -> move(Direction.DOWN);
            case "D" -> move(Direction.RIGHT);
            case "M" -> enterMarket();
            default -> { return false; }
        }
        return true;
    }

    private void move(Direction dir) {
        if (mhLogic.move(dir)) {
            animate();
            mhUI.displayWorld(mhLogic.getWorld());
            checkForBattle();
        }
    }

    private void animate() {
        mhUI.sleepShort();
        mhUI.clearScreen();
    }

    private void checkForBattle() {
        Tile t = mhLogic.getCurrentTile();

        if (mhLogic.isCommonTile(t) && mhLogic.shouldTriggerBattle()) {
            mhUI.printMonstersAppear();
            List<Monster> mons = mhLogic.generateMonstersForParty();
            new Battle(mhLogic.getParty(), mons, in).run();
            mhUI.displayWorld(mhLogic.getWorld());
        }
    }

    private void enterMarket() {
        Tile t = mhLogic.getCurrentTile();
        if (!mhLogic.isMarketTile(t)) {
            mhUI.printNotOnMarketTile();
            return;
        }

        MarketTile mt = mhLogic.asMarketTile(t);
        List<Hero> heroes = mhLogic.getParty().getHeroes();

        mhUI.printChooseMarketHero(heroes);
        String s = in.nextLine().trim();

        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return;
            if (idx < 0 || idx >= heroes.size()) return;
            mt.getMarket().open(in, heroes.get(idx));
        } catch (Exception ignored) {}
    }
}
