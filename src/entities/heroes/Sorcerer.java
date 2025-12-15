package entities.heroes;

import java.util.Arrays;
import java.util.List;

public class Sorcerer extends Hero {
    private static final long serialVersionUID = 1L;

    public Sorcerer(String name, int mana, int strength, int agility,
                    int dexterity, int money, int experience) {
        super(name, mana, strength, agility, dexterity, money, experience);
    }

    @Override
    public String toString() {
        return super.toString() + " [Sorcerer]";
    }

    @Override
    protected List<String> getFavoredAttributes() {
        // Java 8 replacement for List.of(...)
        return Arrays.asList("Dexterity", "Agility");
    }
}
