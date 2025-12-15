package game.services;

import entities.heroes.Hero;
import items.Potion;
/*
 Service class for applying potion effects to heroes.
 Encapsulates potion usage logic.
 */
public final class PotionService {

    private PotionService() {}

    public static void applyPotion(Hero hero, Potion potion) {
        potion.apply(hero);
        hero.removeItem(potion);
    }
}
