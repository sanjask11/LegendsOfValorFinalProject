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

        Party party = setupParty();

        int[] heroNexusCols = chooseHeroLanes(party);   // NEW ✅
        LoVWorld world = new LoVWorld(heroNexusCols);   // CHANGED ✅

        world.display();

        LoVExplorationController controller =
                new LoVExplorationController(in, world, party);

        controller.run();
    }

    private Party setupParty() {
        HeroFactory hf = new HeroFactory();
        System.out.println("Choose 3 heroes for your team:");
        return hf.createParty(in, 3);
    }

    // NEW ✅
    private int[] chooseHeroLanes(Party party) {
        int[] laneToCol = new int[]{0, 3, 6};   // Left/Mid/Right lane start cols
        boolean[] used = new boolean[3];
        int[] cols = new int[3];

        System.out.println("\nChoose lane for each hero (each lane can be used once):");
        System.out.println("1=Left, 2=Middle, 3=Right");

        for (int i = 0; i < party.getHeroes().size(); i++) {
            while (true) {
                System.out.print("Hero " + (i + 1) + " (" + party.getHeroes().get(i).getName() + ") lane [1-3]: ");
                String s = in.nextLine().trim();
                int lane;
                try { lane = Integer.parseInt(s); }
                catch (Exception e) { System.out.println("Enter 1-3."); continue; }

                if (lane < 1 || lane > 3) { System.out.println("Enter 1-3."); continue; }
                if (used[lane - 1]) { System.out.println("That lane already taken."); continue; }

                used[lane - 1] = true;
                cols[i] = laneToCol[lane - 1];
                break;
            }
        }
        return cols;
    }
}
