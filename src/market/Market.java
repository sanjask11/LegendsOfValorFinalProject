package market;

import entities.heroes.*;
import items.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/*
This class represents a single in game market and stores all the items it can sell, it is purely a data holder including all weapons, armor, potions, etc
 */
public class Market implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Weapon> weapons = new ArrayList<>();
    private final List<Armor> armors = new ArrayList<>();
    private final List<Potion> potions = new ArrayList<>();
    private final List<Spell> spells = new ArrayList<>();

    public Market() {
        MarketLoader.loadAll(this);
    }


    public List<Weapon> getWeapons() { return weapons; }
    public List<Armor>  getArmors()  { return armors; }
    public List<Potion> getPotions() { return potions; }
    public List<Spell>  getSpells()  { return spells; }

    public void addWeapon(Weapon w) { weapons.add(w); }
    public void addArmor(Armor a)   { armors.add(a); }
    public void addPotion(Potion p) { potions.add(p); }
    public void addSpell(Spell s)   { spells.add(s); }


    public void open(Scanner in, Hero hero) {
        new MarketController(this, in).open(hero);
    }
}
