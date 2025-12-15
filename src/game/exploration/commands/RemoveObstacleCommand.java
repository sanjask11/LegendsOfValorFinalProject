package game.exploration.commands;

import world.LoVWorld;

import java.util.Scanner;
/*
 Command to remove an obstacle tile at a given (row, col).
 Consumes the turn only if an obstacle is successfully removed.
 */
public class RemoveObstacleCommand implements HeroCommand {

    private final LoVWorld world;
    private final Scanner in;
    // Uses world state + scanner for user input.
    public RemoveObstacleCommand(LoVWorld world, Scanner in) {
        this.world = world;
        this.in = in;
    }
    // Prompts coordinates, then attempts to remove the obstacle.
    @Override
    public boolean execute() {
        System.out.print("Enter obstacleRow obstacleCol: ");
        String[] p = in.nextLine().trim().split("\\s+");
        if (p.length != 2) {
            System.out.println("Invalid input.");
            return false;
        }

        try {
            int r = Integer.parseInt(p[0]);
            int c = Integer.parseInt(p[1]);

            if (world.removeObstacle(r, c)) {
                return true; // consumes turn
            }

            System.out.println("No obstacle there.");
            return false;

        } catch (Exception e) {
            System.out.println("Invalid input.");
            return false;
        }
    }
}
