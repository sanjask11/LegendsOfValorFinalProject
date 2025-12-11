package entities.heroes;

public class Warrior extends Hero {
    private static final long serialVersionUID = 1L;

    public Warrior(String name, int mana, int strength, int agility,
                   int dexterity, int money, int experience) {
        super(name, mana, strength, agility, dexterity, money, experience);
    }

    @Override
    public String toString() {
        return super.toString() + " [Warrior]";
    }

    @Override
    protected java.util.List<String> getFavoredAttributes() {
        return java.util.List.of("Strength", "Agility");
    }
}
