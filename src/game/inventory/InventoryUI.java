package game.inventory;

import entities.heroes.Hero;
import items.Armor;
import items.Item;
import items.Potion;
import items.Weapon;

import java.util.List;
import java.util.Scanner;

/*
This class handles all the input and output related to the inventory.
 */
public final class InventoryUI {

    private final Scanner in;
    // Uses shared Scanner for reading user input.
    public InventoryUI(Scanner in) {
        this.in = in;
    }

    public int promptHeroSelection(List<Hero> heroes) {
        System.out.println("\n=== INVENTORY MENU ===");
        for (int i = 0; i < heroes.size(); i++) {
            System.out.println(i + ": " + heroes.get(i).getName());
        }
        System.out.println("Choose hero (-1 to exit): ");

        String s = in.nextLine().trim();
        int idx;
        try {
            idx = Integer.parseInt(s);
        } catch (Exception e) {
            return -2;  // invalid
        }
        return idx;
    }


    public String promptHeroInventoryAction(Hero hero) {
        System.out.println("\n=== " + hero.getName() + " INVENTORY ===");
        System.out.println("1. View Items");
        System.out.println("2. Equip Weapon");
        System.out.println("3. Equip Armor");
        System.out.println("4. Use Potion");
        System.out.println("0. Back");

        return in.nextLine().trim();
    }

    public void showItems(Hero hero, List<Item> items) {
        System.out.println("\nItems:");
        if (items.isEmpty()) {
            System.out.println("(none)");
            return;
        }
        int i = 0;
        for (Item it : items) {
            System.out.println(i + ": " + it);
            i++;
        }
    }

    // ---- Weapons ----

    public void showNoWeapons() {
        System.out.println("No weapons.");
    }

    public Weapon chooseWeapon(List<Weapon> weapons) {
        System.out.println("\nWeapons:");
        for (int i = 0; i < weapons.size(); i++) {
            System.out.println(i + ": " + weapons.get(i));
        }

        System.out.print("Choose weapon (-1 to cancel): ");
        String s = in.nextLine().trim();
        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= weapons.size()) return null;
            return weapons.get(idx);
        } catch (Exception e) {
            return null;
        }
    }



    public void showNoArmors() {
        System.out.println("No armors.");
    }

    // Prompts armor choice; returns null if canceled/invalid.
    public Armor chooseArmor(List<Armor> armors) {
        System.out.println("\nArmors:");
        for (int i = 0; i < armors.size(); i++) {
            System.out.println(i + ": " + armors.get(i));
        }

        System.out.print("Choose armor (-1 to cancel): ");
        String s = in.nextLine().trim();
        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= armors.size()) return null;
            return armors.get(idx);
        } catch (Exception e) {
            return null;
        }
    }



    public void showNoPotions() {
        System.out.println("No potions.");
    }
    // Prompts potion choice; returns null if canceled/invalid
    public Potion choosePotion(List<Potion> potions) {
        System.out.println("\nPotions:");
        for (int i = 0; i < potions.size(); i++) {
            System.out.println(i + ": " + potions.get(i));
        }

        System.out.print("Choose potion (-1 to cancel): ");
        String s = in.nextLine().trim();
        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= potions.size()) return null;
            return potions.get(idx);
        } catch (Exception e) {
            return null;
        }
    }
    // Generic invalid input message.
    public void printInvalidChoice() {
        System.out.println("Invalid choice.");
    }
}
