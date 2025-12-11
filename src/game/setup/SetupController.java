package game.setup;

import entities.heroes.Hero;
import entities.heroes.HeroFactory;
import world.party.Party;

import java.util.ArrayList;
import java.util.List;

/*
This class deals with coordinating the games setup phase which is the party selection and the world size.
 */
public class SetupController {

    private final SetupLogic logic;
    private final SetupUI ui;
    private final HeroFactory heroFactory;

    public SetupController(SetupLogic logic, SetupUI ui, HeroFactory heroFactory) {
        this.logic = logic;
        this.ui = ui;
        this.heroFactory = heroFactory;
    }

    public Party chooseParty() {
        List<Hero> allHeroes = heroFactory.getAllHeroes();
        List<Hero> selected = new ArrayList<>();

        ui.showHeroList(allHeroes);

        while (selected.size() < 3) {
            Integer raw = ui.askHeroIndexOrFinish();
            if (raw == null) continue;

            if (raw == -1) {
                if (selected.size() >= 1) break;
                ui.requireAtLeastOne();
                continue;
            }

            if (!logic.isValidHeroIndex(raw, allHeroes.size())) {
                ui.invalidIndex();
                continue;
            }

            Hero chosen = allHeroes.get(raw);
            selected.add(chosen);
            ui.showHeroAdded(chosen);
        }

        return logic.createParty(selected);
    }

    public int askWorldSize() {
        while (true) {
            Integer n = ui.askWorldSizeRaw();
            if (n == null) continue;

            if (logic.worldSizeValid(n)) return n;

            ui.askWorldSizeRange();
        }
    }
}
