package game;

import entities.monsters.MonsterFactory;
import game.exploration.MHExplorationController;
import core.Menu;
import world.MHWorld;
import world.party.Party;

import java.util.Random;
import java.util.Scanner;

public class ExplorationMenu implements Menu {

    private final Scanner in;
    private final MHWorld MHWorld;
    private final Party party;
    private final MonsterFactory factory;
    private final Random rng;

    public ExplorationMenu(Scanner in,
                           MHWorld MHWorld,
                           Party party,
                           MonsterFactory factory,
                           Random rng) {
        this.in = in;
        this.MHWorld = MHWorld;
        this.party = party;
        this.factory = factory;
        this.rng = rng;
    }

    @Override
    public void show() {
        new MHExplorationController(in, MHWorld, party, factory, rng).run();
    }
}
