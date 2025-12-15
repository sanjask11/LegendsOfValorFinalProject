package game.exploration.commands;

import entities.heroes.Hero;
import world.LoVWorld;

import java.util.Scanner;
/*
 Command to teleport a hero to a tile adjacent to another hero.
 Consumes the turn only if teleport succeeds.
 */
public class TeleportCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;
    private final Scanner in;
    // Binds this command to a specific hero, world context, and input scanner.
    public TeleportCommand(LoVWorld world, int heroIdx, Hero hero, Scanner in) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
        this.in = in;
    }
    // Prompts target hero + landing direction, then attempts teleport.
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
        // Disallow out-of-range or teleporting to self.
        if (targetHeroIdx < 0 || targetHeroIdx > 2 || targetHeroIdx == heroIdx) {
            System.out.println("Invalid hero index.");
            return false;
        }
        // Get target hero position and compute adjacent landing tile.
        int[] targetPos = world.getHeroPos(targetHeroIdx);
        int tr = targetPos[0];
        int tc = targetPos[1];

        System.out.print("Choose adjacent landing direction (W/A/S/D): ");
        String dir = in.nextLine().trim().toUpperCase();

        int toR = tr;
        int toC = tc;

        // Java 8 compatible switch (no "->")
        // Convert direction input into coordinate offset (Java 8 switch).
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
        // Attempt teleport; consumes turn only on success.
        if (world.teleportHero(heroIdx, targetHeroIdx, toR, toC, hero)) {
            return true; // consumes turn
        }

        System.out.println("Invalid teleport.");
        return false;
    }
}
