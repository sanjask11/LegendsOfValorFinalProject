package world.effects;

import entities.heroes.Hero;

public class KoulouEffect implements TileEffect {
    private final int[] bonusStr = new int[3];

    @Override
    public void apply(int heroIdx, Hero hero) {
        int s = Math.max(1, (int)Math.round(hero.getStrength() * 0.10));
        hero.boostStrength(s);
        bonusStr[heroIdx] = s;
    }

    @Override
    public void clear(int heroIdx, Hero hero) {
        if (bonusStr[heroIdx] != 0) hero.boostStrength(-bonusStr[heroIdx]);
        bonusStr[heroIdx] = 0;
    }
}
