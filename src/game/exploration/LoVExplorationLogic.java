package game.exploration;

import core.Direction;
import world.LoVWorld;
import world.party.Party;
import world.tiles.Tile;

public class LoVExplorationLogic implements ExplorationLogicBase {

    private final LoVWorld world;
    private final Party party;

    public LoVExplorationLogic(LoVWorld world, Party party) {
        this.world = world;
        this.party = party;
    }

    @Override
    public Party getParty() {
        return party;
    }

    public LoVWorld getWorld() {
        return world;
    }

    // --- FIXED: Correct signature ---
    public boolean move(int heroIndex, Direction dir) {
        return world.moveHero(heroIndex, dir);
    }

    public boolean teleport(int heroIndex, int targetRow, int targetCol) {
        return world.teleportHero(heroIndex, targetRow, targetCol);
    }

    public boolean recall(int heroIndex) {
        return world.recallHero(heroIndex);
    }

    public Tile getCurrentTile(int heroIndex) {
        return world.getTileForHero(heroIndex);
    }
}
