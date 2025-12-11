package game.exploration;

import world.AbstractWorld;
import world.party.Party;

public interface ExplorationLogicBase {

    Party getParty();
    AbstractWorld getWorld();

    /** MH uses this. LoV overrides with heroIndex version */
    default world.tiles.Tile getCurrentTile() {
        return null;
    }
}
