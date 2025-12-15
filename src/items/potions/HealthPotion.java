package items.potions;

import entities.heroes.Hero;
import items.Potion;

public class HealthPotion extends Potion {

    private final int amount;

    public HealthPotion(String name, int price, int requiredLevel, int amount) {
        super(name, price, requiredLevel);
        this.amount = amount;
    }

    @Override
    public void apply(Hero hero) {
        hero.healFixed(amount);
        System.out.println(hero.getName() + " gained +" + amount + " health");
    }
}
