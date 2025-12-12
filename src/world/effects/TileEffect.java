package world.effects;

import entities.heroes.Hero;

public interface TileEffect {
    void apply(int heroIdx, Hero hero);
    void clear(int heroIdx, Hero hero);
}

