package items;

import entities.heroes.Hero;
/*
 Abstract potion item.
 Subclasses define how the potion affects a hero.
 */
public abstract class Potion extends Item {

    protected Potion(String name, int price, int requiredLevel) {
        super(name, price, requiredLevel);
    }

    public abstract void apply(Hero hero);
}
