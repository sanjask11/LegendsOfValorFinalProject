package game;

import entities.heroes.HeroFactory;
import game.setup.SetupController;
import game.setup.SetupLogic;
import game.setup.SetupUI;
import world.party.Party;

import java.util.Scanner;

public class SetupMenu {

    private final SetupController controller;

    public SetupMenu(Scanner in, HeroFactory heroFactory) {
        SetupLogic logic = new SetupLogic();
        SetupUI ui = new SetupUI(in);
        this.controller = new SetupController(logic, ui, heroFactory);
    }

    public Party chooseParty() {
        return controller.chooseParty();
    }

    public int askWorldSize() {
        return controller.askWorldSize();
    }
}
