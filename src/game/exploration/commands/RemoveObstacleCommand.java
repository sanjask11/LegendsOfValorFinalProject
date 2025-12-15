package game.exploration.commands;

import world.LoVWorld;

import java.util.Scanner;

public class RemoveObstacleCommand implements HeroCommand {

    private final LoVWorld world;
    private final Scanner in;

    public RemoveObstacleCommand(LoVWorld world, Scanner in) {
        this.world = world;
        this.in = in;
    }

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
