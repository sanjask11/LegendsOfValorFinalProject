package game.exploration;

import world.AbstractWorld;
import world.party.Party;
/*
 Common interface for exploration logic across game modes (MH / LoV).
 Exposes party/world and optionally the current tile (MH only).
 */
public interface ExplorationLogicBase {

    Party getParty();
    AbstractWorld getWorld();

    /** MH uses this. LoV overrides with heroIndex version */
    default world.tiles.Tile getCurrentTile() {
        return null;
    }
}
