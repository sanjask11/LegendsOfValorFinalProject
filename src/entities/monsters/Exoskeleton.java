package entities.monsters;
/*
 * Exoskeleton monster type.
 * Defense-focused monster with copy support.
 */
public class Exoskeleton extends Monster {
    // Constructs an Exoskeleton with the given combat attributes.
    public Exoskeleton(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }

    // Creates and returns a deep copy of this Exoskeleto
    @Override
    public Monster copy() {
        return new Exoskeleton(name, level, damage, defense, dodgeChance);
    }
    // Adds the monster type label for display/debug printing.
    @Override
    public String toString() {
        return "[Exoskeleton] " + super.toString();
    }
}
