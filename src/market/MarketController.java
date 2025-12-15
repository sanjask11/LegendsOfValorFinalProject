package market;

import entities.heroes.Hero;
import items.*;
import java.util.Scanner;

/*
 Controller for the market interaction loop.
 Routes user choices to MarketLogic and MarketUI (buy/sell/exit).
 */
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

            // Java 8 compatible switch (no "->")
            switch (root) {
                case '1':
                    handleBuy(hero);
                    break;
                case '2':
                    handleSell(hero);
                    break;
                case '0':
                    return;
                default:
                    // do nothing
                    break;
            }
        }
    }

    private void handleBuy(Hero hero) {
        while (true) {
            char cat = ui.buyCategoryMenu();

            // Java 8 compatible switch (no "->")
            switch (cat) {
                case '1':
                    buyItem(hero, ui.chooseItem(logic.weapons(market)));
                    break;
                case '2':
                    buyItem(hero, ui.chooseItem(logic.armors(market)));
                    break;
                case '3':
                    buyItem(hero, ui.chooseItem(logic.potions(market)));
                    break;
                case '4':
                    buyItem(hero, ui.chooseItem(logic.spells(market)));
                    break;
                case '0':
                    return;
                default:
                    // do nothing
                    break;
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
