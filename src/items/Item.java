package items;

import java.io.Serializable;

public abstract class Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private final String name;
    private final int price;
    private final int requiredLevel;

    protected Item(String name, int price, int requiredLevel) {
        this.name = name;
        this.price = price;
        this.requiredLevel = requiredLevel;
    }

    public String getName()       { return name; }
    public int getPrice()         { return price; }
    public int getRequiredLevel() { return requiredLevel; }

    @Override
    public String toString() {
        return name + " (Lvl " + requiredLevel + ", Price=" + price + ")";
    }
}

