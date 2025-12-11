package market;

import entities.heroes.Hero;
import items.*;
import java.util.Scanner;

public final class MarketController {

    private final Market market;
    private final MarketLogic logic;
    private final MarketUI ui;

    public MarketController(Market market, Scanner in) {
        this.market = market;
        this.logic = new MarketLogic();
        this.ui = new MarketUI(in);
    }

    public void open(Hero hero) {
        while (true) {
            char root = ui.rootMenu(hero);
            switch (root) {
                case '1' -> handleBuy(hero);
                case '2' -> handleSell(hero);
                case '0' -> { return; }
                default -> { }
            }
        }
    }

    private void handleBuy(Hero hero) {
        while (true) {
            char cat = ui.buyCategoryMenu();

            switch (cat) {
                case '1' -> buyItem(hero, ui.chooseItem(logic.weapons(market)));
                case '2' -> buyItem(hero, ui.chooseItem(logic.armors(market)));
                case '3' -> buyItem(hero, ui.chooseItem(logic.potions(market)));
                case '4' -> buyItem(hero, ui.chooseItem(logic.spells(market)));
                case '0' -> { return; }
            }
        }
    }

    private void buyItem(Hero hero, Item item) {
        if (item == null) return;

        if (!logic.heroCanBuy(hero, item)) {
            if (hero.getLevel() < item.getRequiredLevel()) {
                ui.printLevelTooLow();
            } else {
                ui.printInsufficientGold();
            }
            return;
        }

        logic.buy(hero, item);
        ui.printBought(item);
    }

    private void handleSell(Hero hero) {
        Item item = ui.chooseSellItem(hero);
        if (item == null) return;

        int refund = logic.getSellValue(item);
        logic.sell(hero, item);
        ui.printSold(refund);
    }
}
