package world.effects;

import entities.heroes.Hero;

/*
 BushEffect: when a hero stands on a Bush tile, they gain a temporary DEX bonus.
 The bonus is stored per-hero index so it can be removed correctly when leaving.
 */
public class BushEffect implements TileEffect {
    private final int[] bonusDex = new int[3];

    @Override
    public void apply(int heroIdx, Hero hero) {
        int d = Math.max(1, (int)Math.round(hero.getDexterity() * 0.10));
        hero.boostDexterity(d);
        bonusDex[heroIdx] = d;
    }

    @Override
    public void clear(int heroIdx, Hero hero) {
        if (bonusDex[heroIdx] != 0) hero.boostDexterity(-bonusDex[heroIdx]);
        bonusDex[heroIdx] = 0;
    }
}
