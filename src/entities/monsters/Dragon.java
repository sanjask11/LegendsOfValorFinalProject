package entities.monsters;
import entities.monsters.*;
/*
 Dragon monster type.
 High-damage monster that can be duplicated via copy().
 */
public class Dragon extends Monster {
    // Constructs a Dragon with the given combat attributes.
    public Dragon(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }
    // Creates and returns a deep copy of this Dragon.
    @Override
    public Monster copy() {
        return new Dragon(name, level, damage, defense, dodgeChance);
    }
    // Adds the monster type label for display/debug printing.
    @Override
    public String toString() {
        return "[Dragon] " + super.toString();
    }
}
