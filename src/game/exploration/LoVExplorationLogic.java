package game.exploration;

import core.Direction;
import entities.heroes.Hero;
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

    // Move hero 1 step inside lane
    public boolean move(int heroIndex, Direction dir) {
        Hero h = party.getHeroes().get(heroIndex);
        return world.moveHero(heroIndex, dir, h);
    }

    // Teleport hero to another lane
    public boolean teleport(int heroIndex, int targetRow, int targetCol) {
        System.out.println("Teleport must be done using: choose target hero + adjacent direction (W/A/S/D).");
        return false;
    }

    // Recall hero back to nexus
    public void recall(int heroIndex) {
        Hero h = party.getHeroes().get(heroIndex);
        world.recallHero(heroIndex, h);
    }

    public Tile getCurrentTile(int heroIndex) {
        return world.getTileForHero(heroIndex);
    }
}
