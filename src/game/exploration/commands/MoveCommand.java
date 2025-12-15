package game.exploration.commands;

import core.Direction;
import entities.heroes.Hero;
import world.LoVWorld;
/*
 Command to move a hero one tile in the given direction.
 Consumes the turn only if the move succeeds.
 */
public class MoveCommand implements HeroCommand {

    private final LoVWorld world;
    private final int heroIdx;
    private final Hero hero;
    private final Direction dir;

    public MoveCommand(LoVWorld world, int heroIdx, Hero hero, Direction dir) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
        this.dir = dir;
    }

    @Override
    public boolean execute() {
        if (world.moveHero(heroIdx, dir, hero)) return true;
        System.out.println("Invalid move.");
        return false;
    }
}
