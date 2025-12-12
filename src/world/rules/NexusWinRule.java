package world.rules;

import world.LoVWorld;

public class NexusWinRule {

    public boolean heroesWin(LoVWorld world) {
        for (int i = 0; i < 3; i++) {
            if (world.getHeroPos(i)[0] == 0) return true;
        }
        return false;
    }

    public boolean monstersWin(LoVWorld world) {
        return world.monstersReachHeroNexus();
    }
}
