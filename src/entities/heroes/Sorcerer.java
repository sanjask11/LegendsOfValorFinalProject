package entities.heroes;

import java.util.Arrays;
import java.util.List;

/*
 * Sorcerer hero type.
 * Favors Dexterity and Agility when leveling up.
 */
public class Sorcerer extends Hero {
    private static final long serialVersionUID = 1L;
    // Constructs a Sorcerer with initial stats, gold, and experience.
    public Sorcerer(String name, int mana, int strength, int agility,
                    int dexterity, int money, int experience) {
        super(name, mana, strength, agility, dexterity, money, experience);
    }
    // Adds the hero class label for display/debug printing.
    @Override
    public String toString() {
        return super.toString() + " [Sorcerer]";
    }
    // Defines favored attributes used by Hero.levelUp() scaling.
    @Override
    protected List<String> getFavoredAttributes() {
        // Java 8 replacement for List.of(...)
        return Arrays.asList("Dexterity", "Agility");
    }
}
