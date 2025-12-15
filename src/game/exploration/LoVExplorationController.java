package game.exploration;

import entities.heroes.Hero;
import entities.monsters.MonsterFactory;
import game.InventoryMenu;
import game.exploration.commands.HeroCommand;
import game.exploration.commands.HeroCommandFactory;
import market.Market;
import market.MarketController;
import world.LoVWorld;
import world.party.Party;
import world.tiles.LoVTileType;
import world.tiles.Tile;

import java.util.Scanner;

public class LoVExplorationController extends BaseExplorationController {

    private final LoVWorld world;
    private final Party party;
    private final MonsterFactory monsterFactory;
    private final MarketController marketController;

    public LoVExplorationController(Scanner in, LoVWorld world, Party party) {
        super(in, new LoVExplorationLogic(world, party), new LoVExplorationUI());
        this.world = world;
        this.party = party;
        this.monsterFactory = new MonsterFactory(); // reuse your loader-based factory
        this.marketController = new MarketController(new Market(), in);
    }

    @Override
    public void run() {
        world.spawnMonsters(party, monsterFactory);
        world.display();

        while (true) {

            if (world.heroesWin()) {
                System.out.println("YOU WIN! Hero reached enemy Nexus.");
                return;
            }
            if (world.monstersWin()) {
                System.out.println("YOU LOSE! Monster reached your Nexus.");
                return;
            }

            System.out.println("=== HERO TURN ===");
            for (int i = 0; i < 3; i++) {
                heroTurn(i);
                if (world.heroesWin()) {
                    System.out.println("YOU WIN! Hero reached enemy Nexus.");
                    return;
                }
            }

            System.out.println("=== MONSTER TURN ===");
            world.monstersTurn(party);

            world.cleanupDeadMonstersAndReward(party);
            world.endRoundRegenAndRespawn(party);
            world.nextRound();

            if (world.getRound() % 4 == 0) {
                world.spawnMonsters(party, monsterFactory);
            }

            world.display();
        }
    }

    private void heroTurn(int heroIdx) {
        Hero hero = party.getHeroes().get(heroIdx);

        if (hero.isDead()) {
            System.out.println("Hero " + heroIdx + " is dead (will respawn next round).");
            return;
        }

        while (true) {
            System.out.println("\nHero " + heroIdx + " action:");
            ((LoVExplorationUI) ui).printMainPrompt();

            String cmd = in.nextLine().trim().toUpperCase();

            // Java 8 compatible switch (no "->", no "var")
            switch (cmd) {
                case "I":
                    System.out.println(hero);
                    break;

                case "B":
                    new InventoryMenu(in, party).show();
                    break;

                case "M": {
                    Tile tile = world.getTileForHero(heroIdx);
                    if (tile.getType() == LoVTileType.NEXUS
                            && world.getHeroRow(heroIdx) == LoVWorld.SIZE - 1) {
                        marketController.open(hero);
                    } else {
                        System.out.println("Market can only be used at the Heroes' Nexus (bottom row). Use R to recall.");
                    }
                    break;
                }

                case "Q":
                    System.out.println("Quit.");
                    System.exit(0);
                    break;

                case "P":
                    pauseGame();
                    break;

                case "SG":
                    saveGame();
                    break;

                case "L":
                    loadGame();
                    break;

                default: {
                    HeroCommand command =
                            HeroCommandFactory.create(cmd, world, heroIdx, hero, in, party);

                    if (command == null) {
                        System.out.println("Invalid command.");
                        continue;
                    }

                    if (command.execute()) return; // consumes turn
                    break;
                }
            }
        }
    }

    @Override
    protected boolean handleGameSpecificCommand(String cmd) {
        return false; // unused in LoV custom loop
    }
}
