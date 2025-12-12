package world.effects;

import entities.heroes.Hero;

public class CaveEffect implements TileEffect {
    private final int[] bonusAgi = new int[3];

    @Override
    public void apply(int heroIdx, Hero hero) {
        int a = Math.max(1, (int)Math.round(hero.getAgility() * 0.10));
        hero.boostAgility(a);
        bonusAgi[heroIdx] = a;
    }

    @Override
    public void clear(int heroIdx, Hero hero) {
        if (bonusAgi[heroIdx] != 0) hero.boostAgility(-bonusAgi[heroIdx]);
        bonusAgi[heroIdx] = 0;
    }
}
