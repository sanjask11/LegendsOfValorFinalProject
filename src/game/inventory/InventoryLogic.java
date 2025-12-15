package game.inventory;

import entities.heroes.Hero;
import game.services.PotionService;
import items.Armor;
import items.Item;
import items.Potion;
import items.Weapon;

import java.util.ArrayList;
import java.util.List;

/*
 * This class deals with:
 * - Filtering a hero’s inventory into weapons/armors/potions.
 * - Applying game rules for equipping items.
 * - Applying potion effects on heroes through PotionService.
 */
public final class InventoryLogic {
    // Returns a copy of the hero's inventory list.
    public List<Item> getItems(Hero hero) {
        return new ArrayList<Item>(hero.getInventory());
    }

    public List<Weapon> getWeapons(Hero hero) {
        List<Weapon> weapons = new ArrayList<Weapon>();
        for (Item it : hero.getInventory()) {
            // Java 8: no "instanceof Weapon w"
            if (it instanceof Weapon) {
                weapons.add((Weapon) it);
            }
        }
        return weapons;
    }
    // Collects all armors from inventory.
    public List<Armor> getArmors(Hero hero) {
        List<Armor> armors = new ArrayList<Armor>();
        for (Item it : hero.getInventory()) {

            if (it instanceof Armor) {
                armors.add((Armor) it);
            }
        }
        return armors;
    }

    public List<Potion> getPotions(Hero hero) {
        List<Potion> potions = new ArrayList<Potion>();
        for (Item it : hero.getInventory()) {

            if (it instanceof Potion) {
                potions.add((Potion) it);
            }
        }
        return potions;
    }

    public void equipWeapon(Hero hero, Weapon weapon) {
        if (weapon == null) return;
        hero.equipWeapon(weapon);
    }

    public void equipArmor(Hero hero, Armor armor) {
        if (armor == null) return;
        hero.equipArmor(armor);
    }
    // Applies potion effect then removes it from inventory (null-safe).
    public void usePotion(Hero hero, Potion potion) {
        if (potion == null) return;
        PotionService.applyPotion(hero, potion);
        hero.removeItem(potion);
    }
}
