package entities.heroes;
import world.party.Party;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
This class is responsible for creating and exposing all available heroes.
 */
public class HeroFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Hero> heroes = new ArrayList<>();

    public HeroFactory() {
        HeroLoader.loadAll(heroes);
    }

    public List<Hero> getAllHeroes() {
        return heroes;
    }



    public Party createParty(Scanner in, int count) {
        System.out.println("\n=== HERO SELECTION ===");

        List<Hero> all = getAllHeroes();

        // Print available heroes with indexes
        for (int i = 0; i < all.size(); i++) {
            System.out.println(i + " -> " + all.get(i));
        }

        System.out.println("\nChoose " + count + " heroes by index:");

        List<Hero> chosen = new java.util.ArrayList<>();

        while (chosen.size() < count) {
            System.out.print("Select hero " + (chosen.size() + 1) + ": ");

            try {
                int idx = Integer.parseInt(in.nextLine().trim());

                if (idx < 0 || idx >= all.size()) {
                    System.out.println("Invalid index. Try again.");
                    continue;
                }

                Hero h = all.get(idx);

                if (chosen.contains(h)) {
                    System.out.println("Already chosen. Pick a different hero.");
                    continue;
                }

                chosen.add(h);
                System.out.println("Added: " + h.getName());

            } catch (Exception e) {
                System.out.println("Invalid input. Try again.");
            }
        }

        System.out.println("\n=== FINAL PARTY ===");
        chosen.forEach(System.out::println);

        return new Party(chosen);
    }

}

