package items.spells;

import entities.monsters.Monster;
import items.Spell;

public class LightningSpell extends Spell {

    public LightningSpell(String name, int price, int requiredLevel,
                          int baseDamage, int manaCost, int uses) {
        super(name, price, requiredLevel, baseDamage, manaCost, uses);
    }

    @Override
    public void applyEffect(Monster m) {
        m.reduceDodgeChance(10);
    }

    @Override
    public String toString() {
        return getName() + " [Lightning Spell, dmg=" + baseDamage +
                ", mana=" + manaCost +
                ", uses=" + remainingUses +
                ", lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}
