package entities;

/*
This interface is a common interface for all the combat participants like the heroes and monsters
 */
public interface CombatEntity {

    String getName();
    int getLevel();
    int getHp();
    boolean isDead();

    // Damage Types
    void receivePhysicalDamage(int rawDamage);

    // Dodging
    boolean tryDodge();
}

