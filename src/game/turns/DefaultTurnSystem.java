package game.turns;

import world.LoVWorld;
/*
 Default turn loop for LoV using pluggable strategies (Strategy pattern).
 Alternates hero and monster turns, advancing rounds until win/lose.
 */
public class DefaultTurnSystem implements TurnSystem {

    private final LoVWorld world;
    private final TurnStrategy heroStrategy;
    private final TurnStrategy monsterStrategy;

    public DefaultTurnSystem(LoVWorld world, TurnStrategy heroStrategy, TurnStrategy monsterStrategy) {
        this.world = world;
        this.heroStrategy = heroStrategy;
        this.monsterStrategy = monsterStrategy;
    }

    @Override
    public void run() {
        world.display();

        while (true) {
            // win/lose rules will be checked in controller too, but world-level is fine
            if (world.heroesWin()) { System.out.println("YOU WIN!"); return; }
            if (world.monstersWin()) { System.out.println("YOU LOSE!"); return; }

            heroStrategy.takeTurn();
            if (world.heroesWin()) { System.out.println("YOU WIN!"); return; }

            monsterStrategy.takeTurn();
            if (world.monstersWin()) { System.out.println("YOU LOSE!"); return; }

            world.nextRound();
            world.display();
        }
    }
}
