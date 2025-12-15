package entities.monsters;
/*
 * Spirit monster type.
 * High-dodge monster that supports cloning via copy().
 */
public class Spirit extends Monster {
    // Constructs a Spirit with the given combat attributes.
    public Spirit(String name, int level, int damage, int defense, int dodgeChance) {
        super(name, level, damage, defense, dodgeChance);
    }

    // Creates and returns a deep copy of this Spirit.
    @Override
    public Monster copy() {
        return new Spirit(name, level, damage, defense, dodgeChance);
    }
    // Adds the monster type label for display/debug printing.
    @Override
    public String toString() {
        return "[Spirit] " + super.toString();
    }
}

