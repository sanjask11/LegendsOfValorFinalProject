package game;

import core.Menu;
import game.exploration.LoVExplorationController;
import world.LoVWorld;
import world.party.Party;

import java.util.Scanner;

public class LoVExplorationMenu implements Menu {

    private final Scanner in;
    private final LoVWorld world;
    private final Party party;

    public LoVExplorationMenu(Scanner in, LoVWorld world, Party party) {
        this.in = in;
        this.world = world;
        this.party = party;
    }

    @Override
    public void show() {
        new LoVExplorationController(in, world, party).run();
    }
}
