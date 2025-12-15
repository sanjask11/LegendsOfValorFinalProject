


package world.rules;

import world.tiles.Tile;
/*
 TeleportRule: validates whether a hero teleport action is legal in LoV world.
 */
public class TeleportRule implements Rule<TeleportContext> {

    @Override
    public boolean isValid(TeleportContext ctx) {
        if (!ctx.world.inBounds(ctx.toR, ctx.toC)) return false;

        int[] fromPos = ctx.world.getHeroPos(ctx.heroIdx);
        int fromLane = ctx.world.laneOf(fromPos[1]);

        int targetLane = ctx.world.laneOf(ctx.targetC);
        int destLane = ctx.world.laneOf(ctx.toC);

        // must teleport to a DIFFERENT lane AND land in target hero's lane
        if (fromLane == targetLane) return false;
        if (destLane != targetLane) return false;

        int dr = Math.abs(ctx.toR - ctx.targetR);
        int dc = Math.abs(ctx.toC - ctx.targetC);
        if (dr == 0 && dc == 0) return false;
        if (dr > 1 || dc > 1) return false;


        // cannot teleport ahead of target hero (ahead = smaller row)
        if (ctx.toR < ctx.targetR) return false;

        Tile t = ctx.world.getTile(ctx.toR, ctx.toC);
        if (!t.isAccessible()) return false;

        // must be empty
        if (ctx.world.isHeroOn(ctx.toR, ctx.toC)) return false;

        // cannot teleport behind monsters in that lane
        if (ctx.world.isBehindFrontMonsterInLane(destLane, ctx.toR)) return false;

        return true;
    }

    @Override
    public String message() {
        return "Invalid teleport.";
    }
}
