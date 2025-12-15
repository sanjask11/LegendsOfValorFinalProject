package entities.heroes;

import java.util.Arrays;
import java.util.List;
/*
  Paladin hero type.
 *Favors Strength and Dexterity when leveling up.
 */
public class Paladin extends Hero {
    private static final long serialVersionUID = 1L;

    public Paladin(String name, int mana, int strength, int agility,
                   int dexterity, int money, int experience) {
        super(name, mana, strength, agility, dexterity, money, experience);
    }
    // Adds the hero class label for display/debug printing.
    @Override
    public String toString() {
        return super.toString() + " [Paladin]";
    }

    @Override
    protected List<String> getFavoredAttributes() {
        // Java 8 replacement for List.of(...)
        return Arrays.asList("Strength", "Dexterity");
    }
}
