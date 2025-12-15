package game.exploration.commands;

import entities.heroes.Hero;
import world.LoVMonsterUnit;
import world.LoVWorld;

import java.util.List;

public class AttackCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;

    public AttackCommand(LoVWorld world, int heroIdx, Hero hero) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
    }

    @Override
    public boolean execute() {
        // Java 8: no 'var'
        List<LoVMonsterUnit> targets = world.monstersInRangeOfHero(heroIdx);

        if (targets.isEmpty()) {
            System.out.println("No monsters in range.");
            return false;
        }

        // pick first monster in range (same behavior as before)
        entities.monsters.Monster m = targets.get(0).getMonster();

        if (!m.tryDodge()) {
            hero.attack(m);
        } else {
            System.out.println(m.getName() + " dodged!");
        }
        return true; // consumes turn
    }
}
