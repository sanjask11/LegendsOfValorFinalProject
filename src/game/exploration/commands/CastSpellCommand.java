package game.exploration.commands;

import entities.heroes.Hero;
import items.Item;
import items.Spell;
import world.LoVMonsterUnit;
import world.LoVWorld;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CastSpellCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;
    private final Scanner in;

    public CastSpellCommand(LoVWorld world, int heroIdx, Hero hero, Scanner in) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
        this.in = in;
    }

    @Override
    public boolean execute() {

        // Java 8 compatible: no stream().toList(), no method refs needed
        List<Spell> spells = new ArrayList<Spell>();
        for (Item it : hero.getInventory()) {
            if (it instanceof Spell) {
                Spell sp = (Spell) it;
                if (sp.hasUses()) {
                    spells.add(sp);
                }
            }
        }

        if (spells.isEmpty()) {
            System.out.println("No usable spells available.");
            return false;
        }

        System.out.println("Choose a spell:");
        for (int i = 0; i < spells.size(); i++) {
            System.out.println(i + ": " + spells.get(i));
        }

        try {
            int idx = Integer.parseInt(in.nextLine().trim());
            if (idx < 0 || idx >= spells.size()) {
                System.out.println("Invalid choice.");
                return false;
            }

            Spell spell = spells.get(idx);

            if (hero.getMp() < spell.getManaCost()) {
                System.out.println("Not enough mana.");
                return false;
            }

            // Java 8: no "var"
            List<LoVMonsterUnit> targets = world.monstersInRangeOfHero(heroIdx);
            if (targets.isEmpty()) {
                System.out.println("No monsters in range.");
                return false;
            }

            // pick first monster in range (same behavior as your code)
            entities.monsters.Monster target = targets.get(0).getMonster();

            System.out.println(hero.getName() + " casts " +
                    spell.getName() + " on " + target.getName());

            hero.consumeMana(spell.getManaCost());
            spell.consumeUse();

            if (!target.tryDodge()) {
                target.receiveSpellDamage(spell.getBaseDamage());
                spell.applyEffect(target);
            } else {
                System.out.println(target.getName() + " dodged the spell!");
            }

            return true; // consumes turn

        } catch (Exception e) {
            System.out.println("Invalid input.");
            return false;
        }
    }
}
