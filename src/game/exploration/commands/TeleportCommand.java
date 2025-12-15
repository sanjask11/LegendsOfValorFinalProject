package game.exploration.commands;

import entities.heroes.Hero;
import world.LoVWorld;

import java.util.Scanner;

public class TeleportCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;
    private final Scanner in;

    public TeleportCommand(LoVWorld world, int heroIdx, Hero hero, Scanner in) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
        this.in = in;
    }

    @Override
    public boolean execute() {
        System.out.print("Teleport next to which hero (0/1/2)? ");
        int targetHeroIdx;

        try {
            targetHeroIdx = Integer.parseInt(in.nextLine().trim());
        } catch (Exception e) {
            System.out.println("Invalid hero index.");
            return false;
        }

        if (targetHeroIdx < 0 || targetHeroIdx > 2 || targetHeroIdx == heroIdx) {
            System.out.println("Invalid hero index.");
            return false;
        }

        int[] targetPos = world.getHeroPos(targetHeroIdx);
        int tr = targetPos[0];
        int tc = targetPos[1];

        System.out.print("Choose adjacent landing direction (W/A/S/D): ");
        String dir = in.nextLine().trim().toUpperCase();

        int toR = tr;
        int toC = tc;

        // Java 8 compatible switch (no "->")
        switch (dir) {
            case "W":
                toR--;
                break;
            case "S":
                toR++;
                break;
            case "A":
                toC--;
                break;
            case "D":
                toC++;
                break;
            default:
                System.out.println("Invalid direction.");
                return false;
        }

        if (world.teleportHero(heroIdx, targetHeroIdx, toR, toC, hero)) {
            return true; // consumes turn
        }

        System.out.println("Invalid teleport.");
        return false;
    }
}
