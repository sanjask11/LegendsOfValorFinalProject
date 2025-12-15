package game.battle;

import entities.heroes.Hero;
import entities.monsters.Monster;
import game.services.PotionService;
import items.*;
import world.party.Party;

import java.util.List;

/*
This class contains all the battle mechanics and rules, only calculations and state updates.
 */
public class BattleLogic {

    public Monster pickFirstAliveMonster(List<Monster> monsters) {
        for (Monster m : monsters) if (!m.isDead()) return m;
        return null;
    }

    public Hero pickFirstAliveHero(List<Hero> heroes) {
        for (Hero h : heroes) if (h.isAlive()) return h;
        return null;
    }

    public void heroAttack(Hero h, Monster m) {
        h.attack(m);
    }


    public void heroSpell(Hero h, Monster m, Spell spell) {
        h.consumeMana(spell.getManaCost());

        if (m.tryDodge()) {
            return;
        }

        int base = spell.getBaseDamage();
        int dex = h.getDexterity();
        int dmg = (int) Math.round(base + (dex / 10000.0) * base);

        // 1. apply damage
        m.receiveSpellDamage(dmg);

        // 2. apply spell-specific effect (polymorphism)
        spell.applyEffect(m);

        spell.consumeUse();
    }


    public void usePotion(Hero h, Potion p) {
        PotionService.applyPotion(h, p);
        h.removeItem(p);
    }

    public void equipWeapon(Hero h, Weapon w) { h.equipWeapon(w); }
    public void equipArmor(Hero h, Armor a) { h.equipArmor(a); }

    public boolean allMonstersDead(List<Monster> monsters) {
        for (Monster m : monsters) if (!m.isDead()) return false;
        return true;
    }

    public void rewardHeroes(Party party, List<Monster> monsters) {
        int numMonsters = monsters.size();
        int xpGain = numMonsters * 2;

        int totalGold = 0;
        for (Monster m : monsters) totalGold += m.getLevel() * 100;

        List<Hero> heroes = party.getHeroes();
        int alive = 0;
        for (Hero h : heroes) if (h.isAlive()) alive++;

        int goldEach = (alive == 0) ? 0 : totalGold / alive;

        for (Hero h : heroes) {
            if (h.isAlive()) {
                h.gainExperience(xpGain);
                h.gainGold(goldEach);
            } else {
                h.reviveHalf();
            }
        }
    }

    public void regenHeroes(Party party) {
        for (Hero h : party.getHeroes()) if (h.isAlive()) h.healPercent(0.1);
    }
}
