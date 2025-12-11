package items;

public class Armor extends Item {
    private final int damageReduction;

    public Armor(String name, int price, int requiredLevel,
                 int damageReduction) {
        super(name, price, requiredLevel);
        this.damageReduction = damageReduction;
    }

    public int getDamageReduction() {
        return damageReduction;
    }

    @Override
    public String toString() {
        return getName() + " [Armor -" + damageReduction +
                " dmg, lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}

