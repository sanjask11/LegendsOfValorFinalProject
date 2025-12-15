package items;

import java.io.Serializable;
/*
  Weapon item that adds damage and may require 1 or 2 hands.
 */
public class Weapon extends Item implements Serializable {
    private static final long serialVersionUID = 1L;

    private final int damage;
    private final int hands;

    public Weapon(String name, int price, int requiredLevel,
                  int damage, int hands) {
        super(name, price, requiredLevel);
        this.damage = damage;
        this.hands = hands;
    }

    public int getDamage() { return damage; }
    public int getHands()  { return hands; }

    @Override
    public String toString() {
        return getName() + " [Weapon dmg=" + damage +
                ", hands=" + hands +
                ", lvl=" + getRequiredLevel() +
                ", cost=" + getPrice() + "]";
    }
}

