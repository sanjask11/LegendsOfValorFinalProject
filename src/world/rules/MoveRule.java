package world.rules;

import world.tiles.Tile;

public class MoveRule implements Rule<MoveContext> {

    @Override
    public boolean isValid(MoveContext ctx) {
        if (!ctx.world.inBounds(ctx.toR, ctx.toC)) return false;

        // must stay in same lane
        if (!ctx.world.sameLane(ctx.fromC, ctx.toC)) return false;

        Tile t = ctx.world.getTile(ctx.toR, ctx.toC);
        if (!t.isAccessible()) return false;

        if (ctx.world.isHeroOn(ctx.toR, ctx.toC)) return false;

        // optional: cannot cross monsters
        if (ctx.world.heroCrossesMonster(ctx.heroIdx, ctx.toR, ctx.toC)) return false;

        return true;
    }

    @Override
    public String message() {
        return "Invalid move.";
    }
}
