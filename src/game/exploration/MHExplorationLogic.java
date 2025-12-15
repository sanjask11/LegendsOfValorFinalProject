package game.exploration;

import core.Direction;
import entities.heroes.Hero;
import entities.monsters.Monster;
import entities.monsters.MonsterFactory;
import world.MHWorld;
import world.party.Party;
import world.tiles.CommonTile;
import world.tiles.MarketTile;
import world.tiles.Tile;

import java.util.List;
import java.util.Random;

/*
 * Delegates movement to MHWorld
 * Checks tile type (common / market)
 * Determines encounter chance and generates monsters
 * Exposes Party and World state to controller
 */
public class MHExplorationLogic implements ExplorationLogicBase {

    private final MHWorld world;
    private final Party party;
    private final MonsterFactory monsterFactory;
    private final Random rng;

    public MHExplorationLogic(MHWorld world,
                              Party party,
                              MonsterFactory monsterFactory,
                              Random rng) {
        this.world = world;
        this.party = party;
        this.monsterFactory = monsterFactory;
        this.rng = rng;
    }

    public boolean move(Direction dir) {
        return world.moveParty(dir);
    }

    public Tile getCurrentTile() {
        return world.getCurrentTile();
    }

    public boolean isCommonTile(Tile t) {
        return t instanceof CommonTile;
    }

    public boolean isMarketTile(Tile t) {
        return t instanceof MarketTile;
    }

    // Java 8: no pattern matching "instanceof MarketTile mt"
    public MarketTile asMarketTile(Tile t) {
        if (t instanceof MarketTile) {
            return (MarketTile) t;
        }
        return null;
    }

    public boolean shouldTriggerBattle() {
        return rng.nextDouble() < 0.3;
    }

    public List<Monster> generateMonstersForParty() {
        List<Hero> heroes = party.getHeroes();
        return monsterFactory.generateMonsters(heroes);
    }

    @Override
    public Party getParty() {
        return party;
    }

    @Override
    public MHWorld getWorld() {
        return world; // covariant return type, OK for AbstractWorld
    }
}
