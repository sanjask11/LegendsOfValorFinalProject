package entities;

/*
This interface is a common interface for all the combat participants like the heroes and monsters
 */

public interface CombatEntity {

    String getName();
    int getLevel();
    int getHp();
    boolean isDead();

    boolean tryDodge();
    void receivePhysicalDamage(int rawDamage);

    int computeAttackDamage();

    default void attack(CombatEntity target) {
        if (isDead() || target.isDead()) return;

        System.out.println(getName() + " attacks " + target.getName() + "!");

        if (target.tryDodge()) {
            System.out.println(target.getName() + " dodged!");
            return;
        }

        target.receivePhysicalDamage(computeAttackDamage());
    }
}
