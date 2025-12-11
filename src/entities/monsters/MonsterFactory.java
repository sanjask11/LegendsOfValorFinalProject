package entities.monsters;

import entities.heroes.Hero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/*
This class is responsible for creating and exposing all available monsters.
 */
public class MonsterFactory implements Serializable {

    private static final long serialVersionUID = 1L;

    private final List<Monster> dragons = new ArrayList<>();
    private final List<Monster> spirits = new ArrayList<>();
    private final List<Monster> exoskeletons = new ArrayList<>();

    private static final Random RNG = new Random();

    public MonsterFactory() {
        MonsterLoader.loadAll(this);
    }

    public void addDragon(Dragon d) { dragons.add(d); }
    public void addSpirit(Spirit s) { spirits.add(s); }
    public void addExoskeleton(Exoskeleton e) { exoskeletons.add(e); }

    public List<Monster> generateMonsters(List<Hero> heroes) {
        int count = heroes.size();
        if (count == 0) {
            return List.of();
        }

        // Build list of non-empty pools
        List<List<Monster>> pools = new ArrayList<>();
        if (!dragons.isEmpty())      pools.add(dragons);
        if (!spirits.isEmpty())      pools.add(spirits);
        if (!exoskeletons.isEmpty()) pools.add(exoskeletons);

        if (pools.isEmpty()) {
            System.out.println("Warning: no monsters loaded; skipping battle.");
            return new ArrayList<>();
        }

        List<Monster> result = new ArrayList<>();

        for (int i = 0; i < count; i++) {
            List<Monster> pool = pools.get(RNG.nextInt(pools.size()));
            Monster base = pool.get(RNG.nextInt(pool.size()));
            result.add(base.copy());
        }

        return result;
    }
}

