package game.turns;

import entities.monsters.MonsterFactory;
import world.LoVWorld;
import world.party.Party;
/*
 Monster turn strategy for LoV (Strategy pattern).
 Handles periodic spawning, monster actions, and cleanup/rewards.
 */
public class MonsterTurnStrategy implements TurnStrategy {

    private final LoVWorld world;
    private final Party party;
    private final MonsterFactory mf;

    public MonsterTurnStrategy(LoVWorld world, Party party) {
        this.world = world;
        this.party = party;
        this.mf = new MonsterFactory();
    }

    @Override
    public void takeTurn() {
        // periodic respawn
        if (world.getRound() == 1 || world.getRound() % 4 == 0) {
            world.spawnMonsters(party, mf);
        }

        world.monstersTurn(party);
        world.cleanupDeadMonstersAndReward(party);
        // (optional) regen/respawn end-of-round
        // world.endRoundRegenAndRespawn(party);
    }
}
