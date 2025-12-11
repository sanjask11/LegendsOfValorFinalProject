package game.battle;

import entities.heroes.Hero;
import entities.monsters.Monster;
import items.*;
import world.party.Party;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
This class deals with all battle related user interactions and terminal UI.
 */
public class BattleUI {

    private final Scanner in;

    public BattleUI(Scanner in) {
        this.in = in;
    }



    public String chooseHeroAction(Hero h) {
        System.out.println("\n--- Hero Turn: " + h.getName() + " ---");
        System.out.println("A: Attack");
        System.out.println("S: Cast Spell");
        System.out.println("P: Use Potion");
        System.out.println("E: Equip Weapon/Armor");
        System.out.println("I: Info (heroes + monsters)");
        System.out.println("Q: Skip");
        return in.nextLine().trim().toUpperCase();
    }

    public Monster chooseMonsterTarget(List<Monster> monsters) {
        while (true) {
            System.out.println("\nMonsters:");
            for (int i = 0; i < monsters.size(); i++) {
                Monster m = monsters.get(i);
                System.out.println(i + ": " + m + (m.isDead() ? " (DEAD)" : ""));
            }
            System.out.print("Choose target (-1 to cancel): ");
            String s = in.nextLine().trim();

            try {
                int idx = Integer.parseInt(s);
                if (idx == -1) return null;
                if (idx < 0 || idx >= monsters.size()) continue;

                Monster m = monsters.get(idx);
                if (m.isDead()) {
                    System.out.println("That monster is already dead.");
                    continue;
                }
                return m;
            } catch (NumberFormatException ignored) {
            }
        }
    }

    public Spell chooseSpell(Hero h) {
        List<Spell> spells = new ArrayList<>();
        for (Item it : h.getInventory()) {
            if (it instanceof Spell sp) spells.add(sp);
        }

        if (spells.isEmpty()) {
            System.out.println("No spells in inventory.");
            return null;
        }

        System.out.println("\nSpells:");
        for (int i = 0; i < spells.size(); i++) {
            System.out.println(i + ": " + spells.get(i));
        }
        System.out.print("Choose spell (-1 to cancel): ");
        String s = in.nextLine().trim();

        try {
            int idx = Integer.parseInt(s);
            if (idx == -1) return null;
            if (idx < 0 || idx >= spells.size()) return null;

            Spell sp = spells.get(idx);
            if (!sp.hasUses()) {
                System.out.println("No uses left for that spell.");
                return null;
            }
            return sp;
        } catch (Exception ignored) {
            return null;
        }
    }



    public Potion choosePotion(Hero h) {
        List<Potion> pots = new ArrayList<>();
        for (Item it : h.getInventory()) {
            if (it instanceof Potion p) pots.add(p);
        }

        if (pots.isEmpty()) {
            System.out.println("No potions.");
            return null;
        }

        for (int i = 0; i < pots.size(); i++) {
            System.out.println(i + ": " + pots.get(i));
        }

        System.out.print("Choose potion (-1 to cancel): ");
        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx == -1) return null;
            if (idx < 0 || idx >= pots.size()) return null;
            return pots.get(idx);
        } catch (Exception ignored) {
            return null;
        }
    }

    public Weapon chooseWeapon(Hero hero) {
        List<Weapon> weapons = new ArrayList<>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Weapon w) weapons.add(w);
        }

        if (weapons.isEmpty()) {
            System.out.println("No weapons.");
            return null;
        }

        for (int i = 0; i < weapons.size(); i++) {
            System.out.println(i + ": " + weapons.get(i));
        }

        System.out.print("Choose weapon (-1 to cancel): ");
        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx == -1) return null;
            if (idx < 0 || idx >= weapons.size()) return null;
            return weapons.get(idx);
        } catch (Exception ignored) {
            return null;
        }
    }

    public Armor chooseArmor(Hero hero) {
        List<Armor> armors = new ArrayList<>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Armor a) armors.add(a);
        }

        if (armors.isEmpty()) {
            System.out.println("No armors.");
            return null;
        }

        for (int i = 0; i < armors.size(); i++) {
            System.out.println(i + ": " + armors.get(i));
        }

        System.out.print("Choose armor (-1 to cancel): ");
        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx == -1) return null;
            if (idx < 0 || idx >= armors.size()) return null;
            return armors.get(idx);
        } catch (Exception ignored) {
            return null;
        }
    }



    public void printStatus(Party party, List<Monster> monsters) {
        System.out.println("\n=== STATUS ===");
        System.out.println("Heroes:");
        for (Hero h : party.getHeroes()) System.out.println(" - " + h);
        System.out.println("Monsters:");
        for (Monster m : monsters) System.out.println(" - " + m + (m.isDead() ? " (DEAD)" : ""));
    }

    public void printHeroesWin() {
        System.out.println("\n=== HEROES WIN ===");
    }

    public void printBattleStart() {
        System.out.println("\n=== BATTLE BEGINS ===");
    }

    public void printMonsterTurn() {
        System.out.println("\n--- Monsters' Turn ---");
    }
}
