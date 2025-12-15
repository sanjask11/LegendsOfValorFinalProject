package game.services;

import entities.heroes.Hero;
import items.Potion;

public final class PotionService {

    private PotionService() {}

    public static void applyPotion(Hero hero, Potion potion) {
        potion.apply(hero);
        hero.removeItem(potion);
    }
}
