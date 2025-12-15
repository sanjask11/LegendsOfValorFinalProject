package market;

import entities.heroes.Hero;
import items.*;

import java.util.List;
import java.util.Scanner;
/*
  MarketUI: handles console I/O for market interactions (menus + item selection).
  Does not enforce business rules (handled by MarketLogic).
 */
public final class MarketUI {
    //Shared input scanner (injected from outside to avoid multiple Scanners on System.in).
    private final Scanner in;

    public MarketUI(Scanner in) {
        this.in = in;
    }

    public char rootMenu(Hero hero) {
        System.out.println("\n=== MARKET ===");
        System.out.println("Hero: " + hero.getName() + "  Gold: " + hero.getGold());
        System.out.println("1 Buy");
        System.out.println("2 Sell");
        System.out.println("0 Exit");

        String s = in.nextLine().trim();
        if (s.isEmpty()) return ' ';
        return s.charAt(0);
    }

    public char buyCategoryMenu() {
        System.out.println("\nWhat to buy?");
        System.out.println("1 Weapons");
        System.out.println("2 Armors");
        System.out.println("3 Potions");
        System.out.println("4 Spells");
        System.out.println("0 Back");

        String s = in.nextLine().trim();
        if (s.isEmpty()) return ' ';
        return s.charAt(0);
    }

    public <T extends Item> T chooseItem(List<T> list) {
        if (list.isEmpty()) {
            System.out.println("None available.");
            return null;
        }

        for (int i = 0; i < list.size(); i++)
            System.out.println(i + ": " + list.get(i));

        System.out.print("Choose (-1 cancel): ");
        String s = in.nextLine().trim();
        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= list.size()) return null;
            return list.get(idx);
        } catch (Exception e) {
            return null;
        }
    }

    public Item chooseSellItem(Hero hero) {
        List<Item> inv = hero.getInventory();

        if (inv.isEmpty()) {
            System.out.println("Nothing to sell.");
            return null;
        }

        System.out.println("\nYour items:");
        for (int i = 0; i < inv.size(); i++) {
            System.out.println(i + ": " + inv.get(i)
                    + " -> refund: " + (inv.get(i).getPrice() / 2));
        }

        System.out.print("Choose (-1 cancel): ");
        String s = in.nextLine().trim();
        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= inv.size()) return null;
            return inv.get(idx);
        } catch (Exception e) {
            return null;
        }
    }

    public void printLevelTooLow() {
        System.out.println("Level too low.");
    }

    public void printInsufficientGold() {
        System.out.println("Insufficient gold.");
    }

    public void printBought(Item item) {
        System.out.println("Purchased: " + item.getName());
    }

    public void printSold(int amount) {
        System.out.println("Sold for " + amount + " gold.");
    }
}
