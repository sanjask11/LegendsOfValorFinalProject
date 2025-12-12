package world.effects;

import entities.heroes.Hero;

public class NoEffect implements TileEffect {
    @Override public void apply(int heroIdx, Hero hero) {}
    @Override public void clear(int heroIdx, Hero hero) {}
}
