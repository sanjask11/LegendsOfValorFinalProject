package items;

public class Potion extends Item {
    private final int amount;
    private final String affected;

    public Potion(String name, int price, int requiredLevel,
                  int amount, String affected) {
        super(name, price, requiredLevel);
        this.amount = amount;
        this.affected = affected;
    }

    public int getAmount()      { return amount; }
    public String getAffected() { return affected; }

    @Override
    public String toString() {
        return getName() + " [Potion +" + amount +
                " " + affected +
                ", lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}

