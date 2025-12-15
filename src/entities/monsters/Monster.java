package entities.monsters;

import entities.CombatEntity;
import entities.heroes.Hero;
import items.Spell;

import java.io.Serializable;
import java.util.Random;


/* This class acts an abstract base class for all monster types.
 * Subclasses provide concrete monster categories and must implement copy(), enabling the MonsterFactory to duplicate template monsters for each battle.
 */
public abstract class Monster implements Serializable, CombatEntity {

    private static final long serialVersionUID = 1L;
    protected static final Random RNG = new Random();

    protected final String name;
    protected final int level;

    protected int hp;
    protected int damage;
    protected int defense;
    protected int dodgeChance;

    public Monster(String name, int level, int damage, int defense, int dodgeChance) {
        this.name = name;
        this.level = level;
        this.damage = damage;
        this.defense = defense;
        this.dodgeChance = dodgeChance;
        this.hp = level * 100;
    }
    public void reduceDamage(int amt) {
        damage = Math.max(0, damage - amt);
    }
    public void reduceDefense(int amt) {
        defense = Math.max(0, defense - amt);
    }

    public void reduceDodgeChance(int amt) {
        dodgeChance = Math.max(0, dodgeChance - amt);
    }


    @Override
    public int computeAttackDamage() {
        return Math.max((int)(damage * 0.20), 20);
    }

    @Override
    public String getName() { return name; }

    @Override
    public int getLevel() { return level; }

    @Override
    public int getHp() { return hp; }

    @Override
    public boolean isDead() { return hp <= 0; }

    @Override
    public boolean tryDodge() {
        return RNG.nextInt(100) < dodgeChance;
    }

    @Override
    public void receivePhysicalDamage(int rawDamage) {
        int reduced = (int)(rawDamage * 0.9) - (defense / 10);
        if (reduced < 20) reduced = 20;
        hp -= reduced;
        if (hp < 0) hp = 0;

        System.out.println(name + " took " + reduced + " damage (HP = " + hp + ")");
    }

    public void receiveSpellDamage(int dmg) {
        if (dmg < 20) dmg = 20;
        hp -= dmg;
        if (hp < 0) hp = 0;

        System.out.println(name + " took " + dmg + " spell damage (HP = " + hp + ")");
    }




    public abstract Monster copy();

    @Override
    public String toString() {
        return name + " [Lvl " + level +
                " | HP=" + hp +
                " | DMG=" + damage +
                " | DEF=" + defense +
                " | Dodge=" + dodgeChance + "%]";
    }
}
