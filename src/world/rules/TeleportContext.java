package world.rules;

import entities.heroes.Hero;
import world.LoVWorld;

public class TeleportContext {
    public final LoVWorld world;

    public final int heroIdx;
    public final Hero hero;

    public final int targetHeroIdx;
    public final int targetR;
    public final int targetC;

    public final int toR;
    public final int toC;

    public TeleportContext(LoVWorld world,
                           int heroIdx,
                           Hero hero,
                           int targetHeroIdx,
                           int targetR,
                           int targetC,
                           int toR,
                           int toC) {
        this.world = world;
        this.heroIdx = heroIdx;
        this.hero = hero;
        this.targetHeroIdx = targetHeroIdx;
        this.targetR = targetR;
        this.targetC = targetC;
        this.toR = toR;
        this.toC = toC;
    }
}
