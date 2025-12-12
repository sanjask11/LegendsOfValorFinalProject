package game.exploration;

import core.Direction;
import entities.heroes.Hero;
import entities.monsters.MonsterFactory;
import game.InventoryMenu;
import market.Market;
import market.MarketController;
import world.LoVWorld;
import world.party.Party;
import world.tiles.LoVTileType;

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

    // We don’t use BaseExplorationController.run() for LoV, because LoV is round-based.
    @Override
    public void run() {
        // initial spawn
        world.spawnMonsters(party, monsterFactory);
        world.display();

        while (true) {
            // WIN/LOSE checks
            if (world.heroesWin()) { System.out.println("YOU WIN! Hero reached enemy Nexus."); return; }
            if (world.monstersWin()) { System.out.println("YOU LOSE! Monster reached your Nexus."); return; }

            System.out.println("=== HERO TURN ===");
            for (int i = 0; i < 3; i++) {
                heroTurn(i);
                if (world.heroesWin()) { System.out.println("YOU WIN! Hero reached enemy Nexus."); return; }
            }

            System.out.println("=== MONSTER TURN ===");
            world.monstersTurn(party);

            // cleanup dead monsters -> rewards
            world.cleanupDeadMonstersAndReward(party);

            // end round effects
            world.endRoundRegenAndRespawn(party);

            world.nextRound();

            // periodic respawn
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
            System.out.println("[W/A/S/D]=Move  T=Teleport  R=Recall  M=Market  ATK=Attack  I=Info  B=Inventory  O=RemoveObstacle  Q=Quit");
            String cmd = in.nextLine().trim().toUpperCase();

            switch (cmd) {
                case "I" -> System.out.println(hero);

                case "B" -> new InventoryMenu(in, party).show();

                case "M" -> {
                    // Market only on Heroes' Nexus (bottom row)
                    var tile = world.getTileForHero(heroIdx);
                    if (tile.getType() == LoVTileType.NEXUS && world.getHeroRow(heroIdx) == LoVWorld.SIZE - 1) {
                        marketController.open(hero);
                    } else {
                        System.out.println("Market can only be used at the Heroes' Nexus (bottom row). Use R to recall.");
                    }
                    // Market does NOT consume the hero's action (per PDF)
                }

                case "Q" -> {
                    System.out.println("Quit.");
                    System.exit(0);
                }

                case "W", "A", "S", "D" -> {
                    Direction d = switch (cmd) {
                        case "W" -> Direction.UP;
                        case "A" -> Direction.LEFT;
                        case "S" -> Direction.DOWN;
                        default -> Direction.RIGHT;
                    };
                    if (world.moveHero(heroIdx, d, hero)) return; // consumes action
                    System.out.println("Invalid move.");
                }

                // ✅ UPDATED TELEPORT (PDF rule style)
                case "T" -> {
                    System.out.print("Teleport next to which hero (0/1/2)? ");
                    String sTarget = in.nextLine().trim();
                    int targetHeroIdx;
                    try {
                        targetHeroIdx = Integer.parseInt(sTarget);
                    } catch (Exception e) {
                        System.out.println("Invalid hero index.");
                        break;
                    }

                    if (targetHeroIdx < 0 || targetHeroIdx > 2) {
                        System.out.println("Invalid hero index.");
                        break;
                    }
                    if (targetHeroIdx == heroIdx) {
                        System.out.println("You must teleport near a DIFFERENT hero.");
                        break;
                    }

                    int[] targetPos = world.getHeroPos(targetHeroIdx);
                    int tr = targetPos[0], tc = targetPos[1];

                    System.out.println("Target hero is at (" + tr + ", " + tc + ").");
                    System.out.print("Choose adjacent landing direction relative to target (W/A/S/D): ");
                    String dir = in.nextLine().trim().toUpperCase();

                    int toR = tr, toC = tc;
                    switch (dir) {
                        case "W" -> toR = tr - 1;
                        case "S" -> toR = tr + 1;
                        case "A" -> toC = tc - 1;
                        case "D" -> toC = tc + 1;
                        default -> {
                            System.out.println("Invalid direction.");
                            break;
                        }
                    }

                    // If invalid direction, don't attempt teleport
                    if (!(dir.equals("W") || dir.equals("A") || dir.equals("S") || dir.equals("D"))) break;

                    // ✅ New signature: teleportHero(heroIdx, targetHeroIdx, toR, toC, hero)
                    if (world.teleportHero(heroIdx, targetHeroIdx, toR, toC, hero)) return; // consumes action
                    System.out.println("Invalid teleport.");
                }

                case "R" -> {
                    world.recallHero(heroIdx, hero);
                    return; // consumes action
                }

                case "O" -> {
                    System.out.print("Enter obstacleRow obstacleCol: ");
                    String[] p = in.nextLine().trim().split("\\s+");
                    if (p.length != 2) { System.out.println("Invalid."); break; }
                    int r = Integer.parseInt(p[0]), c = Integer.parseInt(p[1]);
                    if (world.removeObstacle(r, c)) return; // consumes action
                    System.out.println("No obstacle there.");
                }

                case "ATK" -> {
                    var inRange = world.monstersInRangeOfHero(heroIdx);
                    if (inRange.isEmpty()) {
                        System.out.println("No monsters in range.");
                        break;
                    }

                    // pick first for simplicity (same as your code)
                    var target = inRange.get(0).getMonster();

                    System.out.println(hero.getName() + " attacks " + target.getName());
                    if (!target.tryDodge()) {
                        target.receivePhysicalDamage(hero.getAttackDamage());
                    } else {
                        System.out.println(target.getName() + " dodged!");
                    }
                    return; // consumes action
                }

                default -> System.out.println("Invalid command.");
            }
        }
    }

    @Override
    protected boolean handleGameSpecificCommand(String cmd) {
        return false; // unused in LoV custom loop
    }
}
