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
This class deals with
 * - Filtering a hero’s inventory into weapons/armors/potions.
 * - Applying game rules for equipping items.
 * - Applying potion effects on heroes through PotionService.
*/
public final class InventoryLogic {

    public List<Item> getItems(Hero hero) {
        return new ArrayList<>(hero.getInventory());
    }

    public List<Weapon> getWeapons(Hero hero) {
        List<Weapon> weapons = new ArrayList<>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Weapon w) {
                weapons.add(w);
            }
        }
        return weapons;
    }

    public List<Armor> getArmors(Hero hero) {
        List<Armor> armors = new ArrayList<>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Armor a) {
                armors.add(a);
            }
        }
        return armors;
    }

    public List<Potion> getPotions(Hero hero) {
        List<Potion> potions = new ArrayList<>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Potion p) {
                potions.add(p);
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

    public void usePotion(Hero hero, Potion potion) {
        if (potion == null) return;
        PotionService.applyPotion(hero, potion);
        hero.removeItem(potion);
    }
}
