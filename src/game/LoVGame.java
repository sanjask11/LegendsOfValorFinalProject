package game;

import entities.heroes.HeroFactory;
import game.exploration.LoVExplorationController;
import world.LoVWorld;
import world.party.Party;

import java.util.Scanner;

public class LoVGame implements GameMode {

    private final Scanner in = new Scanner(System.in);

    @Override
    public void start() {
        System.out.println("=== LEGENDS OF VALOR ===");

        // 1. Choose 3 heroes
        Party party = setupParty();

        // 2. Create LoV world
        LoVWorld world = new LoVWorld();
        world.display();

        // 3. Start exploration using the shared base system
        LoVExplorationController controller =
                new LoVExplorationController(in, world, party);

        controller.run();
    }

    private Party setupParty() {
        HeroFactory hf = new HeroFactory();

        System.out.println("Choose 3 heroes for your team:");
        System.out.println("(LoV always uses exactly 3 heroes)");

        // Use your existing factory API
        return hf.createParty(in, 3);
    }
}
