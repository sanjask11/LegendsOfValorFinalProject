package world;

import world.effects.*;
import world.rules.*;

import core.Direction;
import entities.heroes.Hero;
import entities.monsters.Monster;
import entities.monsters.MonsterFactory;
import world.effects.*;
import world.party.Party;
import world.rules.*;
import world.tiles.LoVTile;
import world.tiles.LoVTileType;
import world.tiles.Tile;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class LoVWorld extends AbstractWorld implements Serializable {

    public static final int SIZE = 8;

    // hero positions
    private final int[] heroRow = new int[3];
    private final int[] heroCol = new int[3];

    // Small getters used by UI/controller (keeps arrays encapsulated)
    public int getHeroRow(int idx) { return heroRow[idx]; }
    public int getHeroCol(int idx) { return heroCol[idx]; }

    // monsters on the board (multiple per lane possible)
    private final List<LoVMonsterUnit> monsters = new ArrayList<>();

    private final Random rng = new Random();

    private int round = 1;
    private final int spawnEvery = 4;

    // ---- RULES ----
    private final List<Rule<MoveContext>> moveRules = List.of(new MoveRule());
    private final List<Rule<TeleportContext>> teleportRules = List.of(new TeleportRule());
    private final RangeRule rangeRule = new RangeRule();
    private final NexusWinRule nexusWinRule = new NexusWinRule();

    // ---- TILE EFFECTS ----
    // Effects keep internal per-hero bonus tracking, so we don't store bonus arrays here.
    private final TileEffect bushEffect = new BushEffect();
    private final TileEffect caveEffect = new CaveEffect();
    private final TileEffect koulouEffect = new KoulouEffect();
    private final TileEffect noEffect = new NoEffect();


    private final int[] heroSpawnCols;

    public LoVWorld() {
        this(new int[]{0,3,6});
    }

    public LoVWorld(int[] heroSpawnCols) {
        super(SIZE, SIZE);
        this.heroSpawnCols = heroSpawnCols;

        generateWorld();
        placeHeroesAtNexus(heroSpawnCols);
    }


    @Override
    protected void generateWorld() {
        for (int r = 0; r < rows; r++) {
            for (int c = 0; c < cols; c++) {

                // lane separator walls
                if (c == 2 || c == 5) {
                    grid[r][c] = new LoVTile(LoVTileType.WALL);
                    continue;
                }

                // nexus rows
                if (r == 0 || r == rows - 1) {
                    grid[r][c] = new LoVTile(LoVTileType.NEXUS);
                    continue;
                }

                double x = rng.nextDouble();

                if (x < 0.10) grid[r][c] = new LoVTile(LoVTileType.INACCESSIBLE);
                else if (x < 0.20) grid[r][c] = new LoVTile(LoVTileType.OBSTACLE);
                else if (x < 0.35) grid[r][c] = new LoVTile(LoVTileType.BUSH);
                else if (x < 0.50) grid[r][c] = new LoVTile(LoVTileType.CAVE);
                else if (x < 0.65) grid[r][c] = new LoVTile(LoVTileType.KOULOU);
                else grid[r][c] = new LoVTile(LoVTileType.PLAIN);
            }
        }
    }

    private void placeHeroesAtNexus(int[] cols) {
        for (int i = 0; i < 3; i++) {
            heroRow[i] = rows - 1;
            heroCol[i] = cols[i];
        }
    }


    // ---------------------- BASIC GETTERS ----------------------
    public int getRound() { return round; }
    public List<LoVMonsterUnit> getMonsters() { return monsters; }

    public int[] getHeroPos(int idx) { return new int[]{ heroRow[idx], heroCol[idx] }; }

    public Tile getTileForHero(int idx) { return grid[heroRow[idx]][heroCol[idx]]; }

    // ---------------------- HELPERS USED BY RULES ----------------------
    public boolean inBounds(int r, int c) { return r >= 0 && r < rows && c >= 0 && c < cols; }

    public int laneOf(int col) {
        if (col <= 1) return 0;
        if (col <= 4) return 1;
        return 2;
    }

    public boolean sameLane(int colA, int colB) { return laneOf(colA) == laneOf(colB); }

    public Tile getTile(int r, int c) { return grid[r][c]; }

    public boolean isHeroOn(int r, int c) {
        for (int i = 0; i < 3; i++) {
            if (heroRow[i] == r && heroCol[i] == c) return true;
        }
        return false;
    }

    // "cannot cross monsters" helper for MoveRule
    public boolean heroCrossesMonster(int heroIdx, int targetR, int targetC) {
        int lane = laneOf(heroCol[heroIdx]);
        int heroR = heroRow[heroIdx];

        int front = -1;
        for (LoVMonsterUnit mu : monsters) {
            if (mu.getMonster().isDead()) continue;
            if (mu.getLane() != lane) continue;
            if (mu.getRow() < heroR) {
                if (front == -1 || mu.getRow() > front) front = mu.getRow();
            }
        }
        return front != -1 && targetR < front;
    }

    private void setHeroPos(int idx, int r, int c) {
        heroRow[idx] = r;
        heroCol[idx] = c;
    }

    // ---------------------- TILE EFFECT MANAGEMENT ----------------------
    private void clearAllEffects(int heroIdx, Hero hero) {
        bushEffect.clear(heroIdx, hero);
        caveEffect.clear(heroIdx, hero);
        koulouEffect.clear(heroIdx, hero);
    }

    private TileEffect effectForTile(int r, int c) {
        if (!(grid[r][c] instanceof LoVTile lt)) return noEffect;
        return switch (lt.getType()) {
            case BUSH -> bushEffect;
            case CAVE -> caveEffect;
            case KOULOU -> koulouEffect;
            default -> noEffect;
        };
    }

    private void applyEffectForCurrentTile(int heroIdx, Hero hero) {
        int r = heroRow[heroIdx], c = heroCol[heroIdx];
        effectForTile(r, c).apply(heroIdx, hero);
    }

    // ---------------------- OBSTACLE ----------------------
    public boolean removeObstacle(int r, int c) {
        if (!inBounds(r, c)) return false;
        if (grid[r][c] instanceof LoVTile lt && lt.getType() == LoVTileType.OBSTACLE) {
            grid[r][c] = new LoVTile(LoVTileType.PLAIN);
            return true;
        }
        return false;
    }

    // ---------------------- MOVEMENT (RULE-DRIVEN) ----------------------
    public boolean tryMoveHero(int idx, Direction d, Hero hero) {
        int r = heroRow[idx], c = heroCol[idx];
        int nr = r, nc = c;

        switch (d) {
            case UP -> nr--;
            case DOWN -> nr++;
            case LEFT -> nc--;
            case RIGHT -> nc++;
        }

        MoveContext ctx = new MoveContext(this, idx, d, hero, r, c, nr, nc);
        if (!RuleEngine.validate(moveRules, ctx)) return false;

        // update: clear old effects -> move -> apply new effects
        clearAllEffects(idx, hero);
        setHeroPos(idx, nr, nc);
        applyEffectForCurrentTile(idx, hero);
        return true;
    }

    public boolean tryTeleportHero(int idx,
                                   int targetHeroIdx,
                                   int toR,
                                   int toC,
                                   Hero hero) {

        int[] targetPos = getHeroPos(targetHeroIdx);
        int tr = targetPos[0];
        int tc = targetPos[1];

        TeleportContext ctx = new TeleportContext(this, idx, hero, targetHeroIdx, tr, tc, toR, toC);
        if (!RuleEngine.validate(teleportRules, ctx)) return false;

        clearAllEffects(idx, hero);
        setHeroPos(idx, toR, toC);
        applyEffectForCurrentTile(idx, hero);
        return true;
    }


    // Backward-compatible wrappers (if older code still calls these)
    public boolean moveHero(int idx, Direction d, Hero hero) { return tryMoveHero(idx, d, hero); }
    public boolean teleportHero(int idx, int targetHeroIdx, int toR, int toC, Hero hero) {
        return tryTeleportHero(idx, targetHeroIdx, toR, toC, hero);
    }


    public void recallHero(int idx, Hero hero) {
        clearAllEffects(idx, hero);
        setHeroPos(idx, rows - 1, heroSpawnCols[idx]); // 🔥 SAME LANE
        applyEffectForCurrentTile(idx, hero);
    }


    // ---------------------- RANGE / ATTACK ----------------------
    public boolean inRange(int r1, int c1, int r2, int c2) {
        return rangeRule.inRange(r1, c1, r2, c2);
    }

    public List<LoVMonsterUnit> monstersInRangeOfHero(int heroIdx) {
        List<LoVMonsterUnit> res = new ArrayList<>();
        int hr = heroRow[heroIdx], hc = heroCol[heroIdx];

        for (LoVMonsterUnit mu : monsters) {
            if (mu.getMonster().isDead()) continue;
            if (rangeRule.inRange(hr, hc, mu.getRow(), mu.getCol())) res.add(mu);
        }
        return res;
    }

    // simplest "attack first monster in range"
    public boolean tryAttack(int heroIdx, Hero hero) {
        int hr = heroRow[heroIdx], hc = heroCol[heroIdx];

        for (LoVMonsterUnit mu : monsters) {
            if (mu.getMonster().isDead()) continue;
            if (rangeRule.inRange(hr, hc, mu.getRow(), mu.getCol())) {
                // NOTE: if your method names differ, adjust here only.
                mu.getMonster().receivePhysicalDamage(hero.getAttackDamage());
                return true;
            }
        }
        return false;
    }

    // ---------------------- MONSTERS: SPAWN / TURN ----------------------
    public void spawnMonsters(Party party, MonsterFactory mf) {
        int highest = party.getHeroes().stream().mapToInt(Hero::getLevel).max().orElse(1);

        int[][] spawn = new int[][]{
                {0, 1},
                {0, 4},
                {0, 7}
        };

        for (int lane = 0; lane < 3; lane++) {
            Monster m = mf.generateSingleMonster(highest);
            if (m == null) continue;
            monsters.add(new LoVMonsterUnit(m, spawn[lane][0], spawn[lane][1], lane));
        }
    }

    public void monstersTurn(Party party) {
        List<Hero> heroes = party.getHeroes();

        for (LoVMonsterUnit mu : new ArrayList<>(monsters)) {
            Monster m = mu.getMonster();
            if (m.isDead()) continue;

            int targetIdx = -1;
            for (int h = 0; h < 3; h++) {
                int hr = heroRow[h], hc = heroCol[h];
                if (heroes.get(h).isAlive() && rangeRule.inRange(mu.getRow(), mu.getCol(), hr, hc)) {
                    targetIdx = h; break;
                }
            }

            if (targetIdx != -1) {
                m.attack(heroes.get(targetIdx));
                continue;
            }

            int nr = mu.getRow() + 1;
            int nc = mu.getCol();

            if (!inBounds(nr, nc)) continue;
            if (!grid[nr][nc].isAccessible()) continue;

            boolean occupied = false;
            for (LoVMonsterUnit other : monsters) {
                if (other != mu && !other.getMonster().isDead()
                        && other.getRow() == nr && other.getCol() == nc) {
                    occupied = true; break;
                }
            }
            if (occupied) continue;

            // block by heroes (can't cross them)
            int lane = mu.getLane();
            int heroFront = Integer.MAX_VALUE;
            for (int h = 0; h < 3; h++) {
                if (laneOf(heroCol[h]) != lane) continue;
                heroFront = Math.min(heroFront, heroRow[h]);
            }
            if (nr > heroFront) continue;

            mu.setPos(nr, nc);
        }
    }

    public void cleanupDeadMonstersAndReward(Party party) {
        int totalGold = 0;
        int totalExp = 0;

        for (LoVMonsterUnit mu : monsters) {
            if (!mu.getMonster().isDead()) continue;
            int lvl = mu.getMonster().getLevel();
            totalGold += 500 * lvl;
            totalExp += 2 * lvl;
        }

        monsters.removeIf(mu -> mu.getMonster().isDead());

        if (totalGold > 0 || totalExp > 0) {
            for (Hero h : party.getHeroes()) {
                h.gainGold(totalGold);
                h.gainExperience(totalExp);
            }
        }
    }

    // ---------------------- WIN/LOSE ----------------------
    public boolean heroesWin() { return nexusWinRule.heroesWin(this); }

    public boolean monstersReachHeroNexus() {
        for (LoVMonsterUnit mu : monsters) {
            if (!mu.getMonster().isDead() && mu.getRow() == rows - 1) return true;
        }
        return false;
    }

    public boolean monstersWin() { return nexusWinRule.monstersWin(this); }

    // ---------------------- END OF ROUND ----------------------
    public void endRoundRegenAndRespawn(Party party) {
        for (Hero h : party.getHeroes()) {
            if (h.isAlive()) h.healPercent(0.10);
        }
        for (int i = 0; i < 3; i++) {
            Hero h = party.getHeroes().get(i);
            if (h.isDead()) {
                h.reviveHalf();
                recallHero(i, h);
            }
        }
    }

    public void nextRound() {
        round++;
    }

    // ---------------------- DISPLAY ----------------------
    @Override
    public void display() {
        final String RESET    = "\u001B[0m";
        final String HERO_BG  = "\u001B[46;1m"; // bright cyan
        final String MON_BG   = "\u001B[41;1m"; // bright red

        System.out.println("\n=== LEGENDS OF VALOR MAP (Round " + round + ") ===\n");

        for (int r = 0; r < rows; r++) {

            StringBuilder top = new StringBuilder();
            for (int c = 0; c < cols; c++) top.append("╭───╮ ");
            System.out.println(top);

            StringBuilder mid = new StringBuilder();
            for (int c = 0; c < cols; c++) {

                String cell;

                // Show hero / monster overlays (a hero and monster may share a cell)
                int heroHere = -1;
                for (int h = 0; h < 3; h++) {
                    if (heroRow[h] == r && heroCol[h] == c) { heroHere = h; break; }
                }

                boolean monsterHere = false;
                for (LoVMonsterUnit mu : monsters) {
                    if (!mu.getMonster().isDead() && mu.getRow() == r && mu.getCol() == c) {
                        monsterHere = true;
                        break;
                    }
                }

                if (heroHere != -1 && monsterHere) {
                    // Both present -> show "H/M" compactly
                    cell = "H" + heroHere + "/M";
                    cell = String.format("%-3s", cell).substring(0, 3);
                    cell = "\u001B[45;1m" + cell + RESET; // magenta highlight
                } else if (heroHere != -1) {
                    cell = HERO_BG + " " + heroHere + " " + RESET;
                } else if (monsterHere) {
                    cell = MON_BG + " M " + RESET;
                } else {
                    cell = ((LoVTile) grid[r][c]).bgBlock();
                }

                mid.append("│").append(cell).append("│ ");
            }
            System.out.println(mid);

            StringBuilder bottom = new StringBuilder();
            for (int c = 0; c < cols; c++) bottom.append("╰───╯ ");
            System.out.println(bottom);
        }

        // Legend (tiles)
        String nexus     = "│" + new LoVTile(LoVTileType.NEXUS).bgBlock()        + "│";
        String wall      = "│" + new LoVTile(LoVTileType.WALL).bgBlock()         + "│";
        String imp       = "│" + new LoVTile(LoVTileType.INACCESSIBLE).bgBlock() + "│";
        String obstacle  = "│" + new LoVTile(LoVTileType.OBSTACLE).bgBlock()     + "│";
        String bush      = "│" + new LoVTile(LoVTileType.BUSH).bgBlock()         + "│";
        String cave      = "│" + new LoVTile(LoVTileType.CAVE).bgBlock()         + "│";
        String koulou    = "│" + new LoVTile(LoVTileType.KOULOU).bgBlock()       + "│";
        String plain     = "│" + new LoVTile(LoVTileType.PLAIN).bgBlock()        + "│";
        String hero      = "│" + HERO_BG + " 0 " + RESET + "│";
        String mon       = "│" + MON_BG  + " M " + RESET + "│";

        System.out.println("\nLegend:");
        System.out.println("  Heroes        : " + hero);
        System.out.println("  Monsters      : " + mon);
        System.out.println("  Nexus         : " + nexus);
        System.out.println("  Wall          : " + wall);
        System.out.println("  Impassible    : " + imp);
        System.out.println("  Obstacle      : " + obstacle);
        System.out.println("  Bush          : " + bush);
        System.out.println("  Cave          : " + cave);
        System.out.println("  Koulou        : " + koulou);
        System.out.println("  Plain         : " + plain + "\n");
    }

    //--------------------------TELEPORTAITON-------------
    public boolean isBehindFrontMonsterInLane(int lane, int heroRowCandidate) {
        int frontMonsterRow = -1; // highest row number closest to heroes (max row in that lane)

        for (LoVMonsterUnit mu : monsters) {
            if (mu.getMonster().isDead()) continue;
            if (mu.getLane() != lane) continue;

            // monsters move DOWN (increasing row), so "front" for heroes is the monster with greatest row
            if (mu.getRow() > frontMonsterRow) frontMonsterRow = mu.getRow();
        }

        // if there is a monster and hero tries to appear behind it (greater row), not allowed
        return frontMonsterRow != -1 && heroRowCandidate > frontMonsterRow;
    }


    // BACKWARD COMPATIBILITY — old teleport calls (DO NOT USE)
    public boolean teleportHero(int idx, int r, int c, Hero hero) {
        return false;
    }

}
