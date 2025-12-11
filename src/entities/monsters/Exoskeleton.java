package entities.monsters;

public class Exoskeleton extends Monster {

    public Exoskeleton(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }

    @Override
    public Monster copy() {
        return new Exoskeleton(name, level, damage, defense, dodgeChance);
    }

    @Override
    public String toString() {
        return "[Exoskeleton] " + super.toString();
    }
}
