package world.rules;

import world.LoVWorld;
/*
NexusWinRule: checks win conditions for Legends of Valor.
Heroes win if any hero reaches the top row (enemy Nexus side).
Monsters win if they reach the heroes' Nexus (delegated to world logic).
 */
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
