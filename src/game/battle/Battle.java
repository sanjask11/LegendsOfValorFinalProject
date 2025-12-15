package game.battle;

import entities.heroes.Hero;
import entities.monsters.Monster;
import items.*;
import world.party.Party;

import java.util.List;
import java.util.Scanner;

/*
This class deals with coordinating an entire battle sequence.
It delegates interaction to BattleUI and all combat rules to BattleLogic
*/
public class Battle {

    private final Party party;
    private final List<Monster> monsters;

    private final BattleUI ui;
    private final BattleLogic logic;

    public Battle(Party party, List<Monster> monsters, Scanner in) {
        this.party = party;
        this.monsters = monsters;

        this.ui = new BattleUI(in);
        this.logic = new BattleLogic();
    }

    public void run() {
        ui.printBattleStart();
        ui.printStatus(party, monsters);

        while (true) {
            if (logic.allMonstersDead(monsters)) {
                ui.printHeroesWin();
                logic.rewardHeroes(party, monsters);
                return;
            }
            if (party.allDead()) {
                System.out.println("All heroes have fallen. Game over.");
                System.exit(0);
            }

            heroTurn();

            if (logic.allMonstersDead(monsters)) {
                ui.printHeroesWin();
                logic.rewardHeroes(party, monsters);
                return;
            }

            monsterTurn();
            logic.regenHeroes(party);
            ui.printStatus(party, monsters);
        }
    }

    private void heroTurn() {
        for (Hero h : party.getHeroes()) {
            if (!h.isAlive()) continue;

            while (true) {
                String choice = ui.chooseHeroAction(h);

                // Java 8 compatible switch (no "->" blocks)
                if ("A".equals(choice)) {
                    Monster m = ui.chooseMonsterTarget(monsters);
                    if (m != null) logic.heroAttack(h, m);
                    return;

                } else if ("S".equals(choice)) {
                    Spell sp = ui.chooseSpell(h);
                    if (sp == null) continue;
                    Monster m = ui.chooseMonsterTarget(monsters);
                    if (m != null) logic.heroSpell(h, m, sp);
                    return;

                } else if ("P".equals(choice)) {
                    Potion p = ui.choosePotion(h);
                    if (p != null) logic.usePotion(h, p);
                    return;

                } else if ("E".equals(choice)) {
                    // Weapon?
                    Weapon w = ui.chooseWeapon(h);
                    if (w != null) logic.equipWeapon(h, w);

                    // Armor?
                    Armor a = ui.chooseArmor(h);
                    if (a != null) logic.equipArmor(h, a);

                    // NOTE: no return here, so hero can continue choosing actions

                } else if ("I".equals(choice)) {
                    ui.printStatus(party, monsters);

                } else if ("Q".equals(choice)) {
                    return;

                } else {
                    System.out.println("Invalid choice.");
                }
            }
        }
    }

    private void monsterTurn() {
        ui.printMonsterTurn();

        for (Monster m : monsters) {
            if (m.isDead()) continue;

            Hero target = logic.pickFirstAliveHero(party.getHeroes());
            if (target == null) return;

            m.attack(target);
        }
    }
}
