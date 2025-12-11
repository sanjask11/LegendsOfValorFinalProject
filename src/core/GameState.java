package core;

import world.AbstractWorld;
import world.party.Party;

import java.io.Serializable;

/*
 * Represents a complete snapshot of the running game.
 * Stores any world (MHWorld or LoVWorld) + the party.
 */
public class GameState implements Serializable {

    private static final long serialVersionUID = 1L;

    private final AbstractWorld world;
    private final Party party;

    public GameState(AbstractWorld world, Party party) {
        this.world = world;
        this.party = party;
    }

    public AbstractWorld getWorld() {
        return world;
    }

    public Party getParty() {
        return party;
    }
}
