package game.setup;

import entities.heroes.Hero;

import java.util.List;
import java.util.Scanner;

public class SetupUI {

    private final Scanner in;

    public SetupUI(Scanner in) {
        this.in = in;
    }

    public void showHeroList(List<Hero> heroes) {
        System.out.println("\n=== CHOOSE YOUR HEROES (1–3) ===");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(i + ": " + heroes.get(i));
        }
    }

    public Integer askHeroIndexOrFinish() {
        System.out.print("Enter hero index (or -1 to finish): ");
        String s = in.nextLine().trim();
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return null;
        }
    }

    public void showHeroAdded(Hero h) {
        System.out.println(h.getName() + " added to party!");
    }

    public void requireAtLeastOne() {
        System.out.println("Pick at least one hero.");
    }

    public void invalidIndex() {
        System.out.println("Invalid index.");
    }

    // ---- world size UI ----

    public Integer askWorldSizeRaw() {
        System.out.print("Enter world size (default 8): ");
        String s = in.nextLine().trim();
        if (s.isEmpty()) return 8;
        try {
            return Integer.parseInt(s);
        } catch (Exception e) {
            System.out.println("Invalid number.");
            return null;
        }
    }

    public void askWorldSizeRange() {
        System.out.print("Enter number between 4–20: ");
    }
}
