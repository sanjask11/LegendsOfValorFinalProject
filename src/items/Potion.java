package items;

import entities.heroes.Hero;

public abstract class Potion extends Item {

    protected Potion(String name, int price, int requiredLevel) {
        super(name, price, requiredLevel);
    }

    public abstract void apply(Hero hero);
}
