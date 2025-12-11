package game.services;

import entities.heroes.Hero;
import items.Potion;
/*
This class deals with the health factors of the players.
 */
public final class PotionService {

    private PotionService() {
    }

    public static void applyPotion(Hero hero, Potion p) {
        String stat = p.getAffected().toLowerCase();
        int amt = p.getAmount();

        if (stat.contains("health")) {
            int baseHp = hero.getHp();
            if (baseHp > 0) {
                double pct = (double) amt / baseHp;
                hero.healPercent(pct);
            }
        }
        if (stat.contains("mana")) {
            hero.consumeMana(-amt);
        }
        if (stat.contains("strength")) {
            hero.boostStrength(amt);
        }
        if (stat.contains("dexterity")) {
            hero.boostDexterity(amt);
        }
        if (stat.contains("agility")) {
            hero.boostAgility(amt);
        }

        System.out.println(hero.getName() + " gained +" + amt + " " + p.getAffected());
    }
}
