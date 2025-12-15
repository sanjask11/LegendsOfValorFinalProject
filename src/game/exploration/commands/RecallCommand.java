package game.exploration.commands;

import entities.heroes.Hero;
import world.LoVWorld;

public class RecallCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;

    public RecallCommand(LoVWorld world, int heroIdx, Hero hero) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
    }

    @Override
    public boolean execute() {
        world.recallHero(heroIdx, hero);
        return true; // consumes turn
    }
}
