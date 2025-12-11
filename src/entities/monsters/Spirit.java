package entities.monsters;

public class Spirit extends Monster {

    public Spirit(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }

    @Override
    public Monster copy() {
        return new Spirit(name, level, damage, defense, dodgeChance);
    }

    @Override
    public String toString() {
        return "[Spirit] " + super.toString();
    }
}

