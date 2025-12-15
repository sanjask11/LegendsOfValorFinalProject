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

    private final List<Monster> dragons = new ArrayList<Monster>();
    private final List<Monster> spirits = new ArrayList<Monster>();
    private final List<Monster> exoskeletons = new ArrayList<Monster>();

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
            // Java 8: no List.of()
            return new ArrayList<Monster>();
        }

        // Build list of non-empty pools
        List<List<Monster>> pools = new ArrayList<List<Monster>>();
        if (!dragons.isEmpty())      pools.add(dragons);
        if (!spirits.isEmpty())      pools.add(spirits);
        if (!exoskeletons.isEmpty()) pools.add(exoskeletons);

        if (pools.isEmpty()) {
            System.out.println("Warning: no monsters loaded; skipping battle.");
            return new ArrayList<Monster>();
        }

        List<Monster> result = new ArrayList<Monster>();

        for (int i = 0; i < count; i++) {
            List<Monster> pool = pools.get(RNG.nextInt(pools.size()));
            Monster base = pool.get(RNG.nextInt(pool.size()));
            result.add(base.copy());
        }

        return result;
    }

    public Monster generateSingleMonster(int level) {

        // Build list of non-empty pools
        List<List<Monster>> pools = new ArrayList<List<Monster>>();
        if (!dragons.isEmpty())      pools.add(dragons);
        if (!spirits.isEmpty())      pools.add(spirits);
        if (!exoskeletons.isEmpty()) pools.add(exoskeletons);

        if (pools.isEmpty()) {
            System.out.println("Warning: no monsters loaded.");
            return null; // caller should handle null
        }

        // Flatten all monsters into one list
        List<Monster> all = new ArrayList<Monster>();
        for (List<Monster> pool : pools) {
            all.addAll(pool);
        }

        if (all.isEmpty()) {
            System.out.println("Warning: monster pools empty.");
            return null;
        }

        // Prefer exact-level monsters, else closest-level monster
        Monster best = null;
        int bestDiff = Integer.MAX_VALUE;

        for (Monster m : all) {
            int diff = Math.abs(m.getLevel() - level);
            if (diff < bestDiff) {
                bestDiff = diff;
                best = m;
            } else if (diff == bestDiff && RNG.nextBoolean()) {
                // tie-breaker randomness
                best = m;
            }
        }

        return (best == null) ? null : best.copy();
    }
}
