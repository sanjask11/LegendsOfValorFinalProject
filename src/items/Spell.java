package items;

public class Spell extends Item {

    private final SpellType type;
    private final int baseDamage;
    private final int manaCost;
    private int remainingUses;

    public Spell(String name, SpellType type,
                 int price, int requiredLevel,
                 int baseDamage, int manaCost,
                 int uses) {
        super(name, price, requiredLevel);
        this.type = type;
        this.baseDamage = baseDamage;
        this.manaCost = manaCost;
        this.remainingUses = uses;
    }

    public SpellType getType()   { return type; }
    public int getBaseDamage()   { return baseDamage; }
    public int getManaCost()     { return manaCost; }

    public boolean hasUses()     { return remainingUses > 0; }

    public void consumeUse() {
        if (remainingUses > 0) remainingUses--;
    }

    @Override
    public String toString() {
        return getName() + " [" + type +
                ", dmg=" + baseDamage +
                ", mana=" + manaCost +
                ", uses=" + remainingUses +
                ", lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}

