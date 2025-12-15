package items;
/*
 Abstract spell item with damage, mana cost, and limited uses.
 Subclasses implement applyEffect() to add a debuff/special effect.
 */
public abstract class Spell extends Item {

    protected final int baseDamage;
    protected final int manaCost;
    protected int remainingUses;

    protected Spell(String name, int price, int requiredLevel,
                    int baseDamage, int manaCost, int uses) {
        super(name, price, requiredLevel);
        this.baseDamage = baseDamage;
        this.manaCost = manaCost;
        this.remainingUses = uses;
    }

    public int getBaseDamage() { return baseDamage; }
    public int getManaCost() { return manaCost; }

    public boolean hasUses() { return remainingUses > 0; }

    public void consumeUse() {
        if (remainingUses > 0) remainingUses--;
    }

    public abstract void applyEffect(entities.monsters.Monster m);
}
