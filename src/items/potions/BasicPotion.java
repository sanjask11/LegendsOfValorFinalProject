package items.potions;

import entities.heroes.Hero;
import items.Potion;

public class BasicPotion extends Potion {

    private final int amount;
    private final String affected;

    public BasicPotion(String name, int price, int requiredLevel,
                       int amount, String affected) {
        super(name, price, requiredLevel);
        this.amount = amount;
        this.affected = affected.toLowerCase();
    }

    @Override
    public void apply(Hero hero) {
        if (affected.contains("health")) hero.healFixed(amount);
        if (affected.contains("mana")) hero.consumeMana(-amount);
        if (affected.contains("strength")) hero.boostStrength(amount);
        if (affected.contains("dexterity")) hero.boostDexterity(amount);
        if (affected.contains("agility")) hero.boostAgility(amount);
    }

    @Override
    public String toString() {
        return getName() + " [Potion +" + amount + " " + affected + "]";
    }
}
