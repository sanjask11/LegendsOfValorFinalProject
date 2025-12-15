package game.turns;

import core.Direction;
import entities.heroes.Hero;
import world.LoVWorld;
import world.party.Party;

import java.util.Scanner;
/*
 Hero turn strategy for LoV (Strategy pattern).
 Reads commands from console and applies actions until each hero consumes a turn.
 */
public class HeroTurnStrategy implements TurnStrategy {

    private final Scanner in;
    private final LoVWorld world;
    private final Party party;

    public HeroTurnStrategy(Scanner in, LoVWorld world, Party party) {
        this.in = in;
        this.world = world;
        this.party = party;
    }
    // Executes turns for the 3 heroes in order (skip dead heroes).
    @Override
    public void takeTurn() {
        for (int i = 0; i < 3; i++) {
            Hero h = party.getHeroes().get(i);
            if (h.isDead()) {
                System.out.println("Hero " + i + " dead (skipping).");
                continue;
            }

            while (true) {
                System.out.println("\nHero " + i + " action: W/A/S/D Move | T Teleport | R Recall | ATK Attack | O RemoveObstacle");
                String cmd = in.nextLine().trim().toUpperCase();

                switch (cmd) {
                    case "W","A","S","D" -> {
                        Direction d = switch (cmd) {
                            case "W" -> Direction.UP;
                            case "A" -> Direction.LEFT;
                            case "S" -> Direction.DOWN;
                            default -> Direction.RIGHT;
                        };
                        if (world.tryMoveHero(i, d, h)) return; // consumes action
                        System.out.println("Invalid move.");
                    }


                    case "T" -> {
                        System.out.print("Teleport next to which hero (0/1/2)? ");
                        int targetHeroIdx;
                        try {
                            targetHeroIdx = Integer.parseInt(in.nextLine().trim());
                        } catch (Exception e) {
                            System.out.println("Invalid hero index.");
                            break;
                        }

                        if (targetHeroIdx < 0 || targetHeroIdx > 2) {
                            System.out.println("Invalid hero index.");
                            break;
                        }
                        if (targetHeroIdx == i) {
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

                        if (!(dir.equals("W") || dir.equals("A") || dir.equals("S") || dir.equals("D"))) break;


                        if (world.tryTeleportHero(i, targetHeroIdx, toR, toC, h)) return;
                        System.out.println("Invalid teleport.");
                    }

                    case "R" -> {
                        world.recallHero(i, h);
                        return;
                    }

                    case "O" -> {
                        System.out.print("Enter obstacle row col: ");
                        String[] p = in.nextLine().trim().split("\\s+");
                        if (p.length != 2) { System.out.println("Invalid."); break; }
                        int r = Integer.parseInt(p[0]), c = Integer.parseInt(p[1]);
                        if (world.removeObstacle(r, c)) return;
                        System.out.println("No obstacle there.");
                    }

                    case "ATK" -> {
                        if (world.tryAttack(i, h)) return;
                        System.out.println("No monster in range.");
                    }

                    default -> System.out.println("Invalid command.");
                }
            }
        }
    }
}
