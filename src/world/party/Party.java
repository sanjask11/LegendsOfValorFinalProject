package world.party;
import entities.heroes.*;

import java.io.Serializable;
import java.util.List;
/*
This class deals with the players party on the game grid, it proceeds to store the list of chosen heroes, partys current position in the world.
 */
public class Party implements Serializable {
    private static final long serialVersionUID = 1L;

    private final List<Hero> heroes;
    private int row;
    private int col;

    public Party(List<Hero> heroes) {
        this.heroes = heroes;
    }

    public void setPosition(int r, int c) { row = r; col = c; }

    public int getRow() { return row; }
    public int getCol() { return col; }
    public List<Hero> getHeroes() { return heroes; }

    public boolean allDead() {
        return heroes.stream().noneMatch(Hero::isAlive);
    }
}

