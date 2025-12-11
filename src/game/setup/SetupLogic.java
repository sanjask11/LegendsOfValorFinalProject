package game.setup;

import entities.heroes.Hero;
import world.party.Party;

import java.util.ArrayList;
import java.util.List;

public class SetupLogic {

    public Party createParty(List<Hero> chosenHeroes) {
        return new Party(chosenHeroes);
    }

    public boolean isValidHeroIndex(int idx, int size) {
        return idx >= 0 && idx < size;
    }

    public boolean worldSizeValid(int n) {
        return n >= 4 && n <= 20;
    }
}
