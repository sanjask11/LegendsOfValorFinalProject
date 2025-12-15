package market;

import entities.heroes.Hero;
import items.*;

import java.util.List;
/*
 MarketLogic: contains core market rules (buy/sell checks + transactions),
 and provides accessors to market inventories.
 */
public final class MarketLogic {

    public boolean heroCanBuy(Hero hero, Item item) {
        if (hero.getLevel() < item.getRequiredLevel()) return false;
        return hero.getGold() >= item.getPrice();
    }

    public void buy(Hero hero, Item item) {
        if (item == null) return;
        hero.spendGold(item.getPrice());
        hero.addItem(item);
    }

    public int getSellValue(Item item) {
        return item.getPrice() / 2;
    }

    public void sell(Hero hero, Item item) {
        int refund = getSellValue(item);
        hero.gainGold(refund);
        hero.removeItem(item);
    }


    public List<Weapon> weapons(Market m) { return m.getWeapons(); }
    public List<Armor> armors(Market m) { return m.getArmors(); }
    public List<Potion> potions(Market m) { return m.getPotions(); }
    public List<Spell> spells(Market m) { return m.getSpells(); }
}
