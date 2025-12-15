package game.exploration.commands;

import entities.heroes.Hero;
import world.LoVWorld;

/*
 Command that recalls a hero to the nexus.
 Always consumes the hero's turn.
 */
public class RecallCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;
    // Binds this command to a specific hero and world context.
    public RecallCommand(LoVWorld world, int heroIdx, Hero hero) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
    }
    // Executes recall logic in the world.
    @Override
    public boolean execute() {
        world.recallHero(heroIdx, hero);
        return true; // consumes turn
    }
}
