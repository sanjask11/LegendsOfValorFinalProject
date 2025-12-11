package game;

import core.Menu;
import game.inventory.InventoryController;
import world.party.Party;

import java.util.Scanner;


public class InventoryMenu implements Menu {

    private final InventoryController controller;

    public InventoryMenu(Scanner in, Party party) {
        this.controller = new InventoryController(party, in);
    }

    @Override
    public void show() {
        controller.openInventory();
    }
}
