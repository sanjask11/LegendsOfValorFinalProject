package items.spells;

import items.Spell;
import entities.monsters.Monster;

public class FireSpell extends Spell {

    public FireSpell(String name, int price, int level,
                     int baseDamage, int manaCost, int uses) {
        super(name, price, level, baseDamage, manaCost, uses);
    }

    @Override
    public void applyEffect(Monster m) {
        m.reduceDefense(10);
    }
}

