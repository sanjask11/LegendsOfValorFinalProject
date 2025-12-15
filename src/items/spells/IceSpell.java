package items.spells;

import entities.monsters.Monster;
import items.Spell;
/*
 Ice spell that deals damage and weakens the monster's attack power.
 */
public class IceSpell extends Spell {

    public IceSpell(String name, int price, int requiredLevel,
                    int baseDamage, int manaCost, int uses) {
        super(name, price, requiredLevel, baseDamage, manaCost, uses);
    }

    @Override
    public void applyEffect(Monster m) {
        m.reduceDamage(10);
    }

    @Override
    public String toString() {
        return getName() + " [Ice Spell, dmg=" + baseDamage +
                ", mana=" + manaCost +
                ", uses=" + remainingUses +
                ", lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}
