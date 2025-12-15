package game.exploration.commands;

import entities.heroes.Hero;
import game.services.PotionService;
import items.Item;
import items.Potion;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class UsePotionCommand implements HeroCommand {

    private final Hero hero;
    private final Scanner in;

    public UsePotionCommand(Hero hero, Scanner in) {
        this.hero = hero;
        this.in = in;
    }

    @Override
    public boolean execute() {
        // Java 8 compatible: no streams + no toList()
        List<Potion> potions = new ArrayList<Potion>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Potion) {
                potions.add((Potion) it);
            }
        }

        if (potions.isEmpty()) {
            System.out.println("No potions available.");
            return false;
        }

        System.out.println("Choose a potion:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println(i + ": " + potions.get(i));
        }

        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx < 0 || idx >= potions.size()) {
                System.out.println("Invalid choice.");
                return false;
            }

            Potion p = potions.get(idx);
            PotionService.applyPotion(hero, p);
            hero.removeItem(p);

            System.out.println("Potion used.");
            return true; // consumes turn

        } catch (Exception e) {
            System.out.println("Invalid input.");
            return false;
        }
    }
}
