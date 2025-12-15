package game.inventory;

import entities.heroes.Hero;
import items.Armor;
import items.Potion;
import items.Weapon;
import world.party.Party;

import java.util.List;
import java.util.Scanner;

/*
 * This class controls the flow of the inventory system.
 * Lets the player choose which inventory to view, etc.
 */
public final class InventoryController {

    private final Party party;
    private final InventoryLogic logic;
    private final InventoryUI ui;

    public InventoryController(Party party, Scanner in) {
        this.party = party;
        this.logic = new InventoryLogic();
        this.ui = new InventoryUI(in);
    }

    public void openInventory() {
        List<Hero> heroes = party.getHeroes();

        while (true) {
            int idx = ui.promptHeroSelection(heroes);

            if (idx == -1) {
                // Exit inventory
                return;
            }
            if (idx < 0 || idx >= heroes.size()) {
                // invalid input, just loop
                continue;
            }

            Hero hero = heroes.get(idx);
            heroInventoryLoop(hero);
        }
    }

    private void heroInventoryLoop(Hero hero) {
        while (true) {
            String choice = ui.promptHeroInventoryAction(hero);

            // Java 8 compatible switch (no "->")
            switch (choice) {
                case "1":
                    ui.showItems(hero, logic.getItems(hero));
                    break;

                case "2":
                    handleEquipWeapon(hero);
                    break;

                case "3":
                    handleEquipArmor(hero);
                    break;

                case "4":
                    handleUsePotion(hero);
                    break;

                case "0":
                    return; // back to hero selection

                default:
                    ui.printInvalidChoice();
                    break;
            }
        }
    }

    private void handleEquipWeapon(Hero hero) {
        List<Weapon> weapons = logic.getWeapons(hero);
        if (weapons.isEmpty()) {
            ui.showNoWeapons();
            return;
        }
        Weapon chosen = ui.chooseWeapon(weapons);
        if (chosen == null) return;
        logic.equipWeapon(hero, chosen);
    }

    private void handleEquipArmor(Hero hero) {
        List<Armor> armors = logic.getArmors(hero);
        if (armors.isEmpty()) {
            ui.showNoArmors();
            return;
        }
        Armor chosen = ui.chooseArmor(armors);
        if (chosen == null) return;
        logic.equipArmor(hero, chosen);
    }

    private void handleUsePotion(Hero hero) {
        List<Potion> potions = logic.getPotions(hero);
        if (potions.isEmpty()) {
            ui.showNoPotions();
            return;
        }
        Potion chosen = ui.choosePotion(potions);
        if (chosen == null) return;
        logic.usePotion(hero, chosen);
    }
}
