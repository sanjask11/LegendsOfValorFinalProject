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

    // Teleport hero to a cell adjacent to a target hero in a different lane.
    // (UI keeps asking for destination: heroIndex row col.)
    public boolean teleport(int heroIndex, int targetRow, int targetCol) {
        Hero h = party.getHeroes().get(heroIndex);
        return world.teleportHero(heroIndex, targetRow, targetCol, h);
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
