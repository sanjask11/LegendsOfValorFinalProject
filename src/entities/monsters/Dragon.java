package entities.monsters;
import entities.monsters.*;

public class Dragon extends Monster {

    public Dragon(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }

    @Override
    public Monster copy() {
        return new Dragon(name, level, damage, defense, dodgeChance);
    }

    @Override
    public String toString() {
        return "[Dragon] " + super.toString();
    }
}
