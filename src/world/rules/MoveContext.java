package world.rules;

import core.Direction;
import entities.heroes.Hero;
import world.LoVWorld;
/*
 MoveContext: a simple data holder describing one attempted hero move.
 Used by movement/rule checks to avoid passing many parameters around.
 */
public class MoveContext {
    public final LoVWorld world;
    public final int heroIdx;
    public final Direction dir;
    public final Hero hero;

    public final int fromR, fromC;
    public final int toR, toC;

    public MoveContext(LoVWorld world, int heroIdx, Direction dir, Hero hero,
                       int fromR, int fromC, int toR, int toC) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.dir = dir;
        this.hero = hero;
        this.fromR = fromR;
        this.fromC = fromC;
        this.toR = toR;
        this.toC = toC;
    }
}
