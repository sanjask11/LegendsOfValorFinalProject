package entities.heroes;

import entities.CombatEntity;
import items.Armor;
import items.Item;
import items.Weapon;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/*
This class is the core abstract class for all hero types and,
 * Encapsulates common RPG attributes (HP, MP, stats, gold, level),
 * inventory and equipment handling, combat interactions, leveling logic,
 * and dodge/attack calculations.

 * Concrete hero classes like Warrior,Sorcerer,Paladin extend this and supply
 * favored attributes so level ups can apply class specific scaling.

 Acts as the main player controlled combat entity used throughout
 */

public abstract class Hero implements Serializable, CombatEntity {

    private static final long serialVersionUID = 1L;
    protected static final Random RNG = new Random();

    private final String name;

    private int level;
    private int experience;
    private int gold;

    private int hp;
    private int mp;

    private int strength;
    private int dexterity;
    private int agility;

    private final List<Item> inventory = new ArrayList<>();
    private Weapon weapon;
    private Armor armor;

    public Hero(String name,
                int baseMana,
                int strength,
                int agility,
                int dexterity,
                int startingGold,
                int startingExperience) {

        this.name = Objects.requireNonNull(name);

        this.level = 1;
        this.experience = startingExperience;
        this.gold = startingGold;

        this.hp = level * 100;
        this.mp = baseMana;

        this.strength = strength;
        this.dexterity = dexterity;
        this.agility = agility;
    }

    public int getStrength() { return strength; }
    public int getDexterity() { return dexterity; }
    public int getAgility()  { return agility; }

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
        return tryDodgeAttack();
    }

    public int getMp() { return mp; }
    public int getGold() { return gold; }

    public Weapon getWeapon() { return weapon; }
    public Armor getArmor() { return armor; }
    public List<Item> getInventory() { return inventory; }

    public boolean isAlive() { return hp > 0; }

    public double getDodgeChance() {
        double chance = agility * 0.002;
        return Math.min(chance, 0.60);
    }

    public boolean tryDodgeAttack() {
        return RNG.nextDouble() < getDodgeChance();
    }

    public int getAttackDamage() {
        int weaponDamage = weapon == null ? 0 : weapon.getDamage();
        double base = strength + weaponDamage;
        return (int)(base * 0.80);
    }

    @Override
    public void receivePhysicalDamage(int dmg) {
        int reduction = armor == null ? 0 : armor.getDamageReduction();
        int finalDamage = dmg - reduction;
        if (finalDamage < 15) finalDamage = 15;

        hp -= finalDamage;
        if (hp < 0) hp = 0;

        System.out.println(name + " took " + finalDamage + " damage (HP = " + hp + ")");
    }

    public void consumeMana(int amt) {
        mp -= amt;
        if (mp < 0) mp = 0;
    }

    public void healFixed(int amount) {
        hp += amount;
    }

    public void healPercent(double pct) {
        hp += (int)Math.round((level * 100) * pct);
        mp += (int)Math.round(mp * pct);
    }

    public void addItem(Item it) { inventory.add(it); }
    public void removeItem(Item it) { inventory.remove(it); }

    public void equipWeapon(Weapon w) {
        weapon = w;
        if (!inventory.contains(w)) inventory.add(w);
        System.out.println(name + " equipped weapon " + w.getName());
    }

    public void equipArmor(Armor a) {
        armor = a;
        if (!inventory.contains(a)) inventory.add(a);
        System.out.println(name + " equipped armor " + a.getName());
    }

    public boolean spendGold(int amt) {
        if (amt > gold) return false;
        gold -= amt;
        return true;
    }

    public void gainGold(int amt) {
        gold += amt;
    }

    public void gainExperience(int amt) {
        experience += amt;
        while (experience >= level * 10) {
            experience -= level * 10;
            levelUp();
        }
    }

    protected abstract List<String> getFavoredAttributes();

    private void levelUp() {
        level++;

        strength = (int)(strength * 1.05);
        dexterity = (int)(dexterity * 1.05);
        agility  = (int)(agility  * 1.05);

        List<String> fav = getFavoredAttributes();
        if (fav.contains("Strength"))  strength = (int)(strength * 1.05);
        if (fav.contains("Dexterity")) dexterity = (int)(dexterity * 1.05);
        if (fav.contains("Agility"))   agility  = (int)(agility  * 1.05);

        hp = level * 100;
        mp = (int)(mp * 1.10);

        System.out.println(name + " leveled up! Now level " + level);
    }

    public void reviveHalf() {
        if (hp <= 0) {
            hp = (level * 100) / 2;
            mp = mp / 2;
        }
    }

    public void boostStrength(int delta) { strength += delta; }
    public void boostDexterity(int delta) { dexterity += delta; }
    public void boostAgility(int delta) { agility += delta; }

    @Override
    public String toString() {
        return name + " [Lvl " + level +
                ", HP=" + hp +
                ", MP=" + mp +
                ", STR=" + strength +
                ", DEX=" + dexterity +
                ", AGI=" + agility +
                ", Gold=" + gold + "]";
    }
}
