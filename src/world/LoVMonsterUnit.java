package world;

import entities.monsters.Monster;

import java.io.Serializable;

public class LoVMonsterUnit implements Serializable {
    private static final long serialVersionUID = 1L;

    private final Monster monster;
    private int row;
    private int col;
    private final int lane; // 0,1,2

    public LoVMonsterUnit(Monster monster, int row, int col, int lane) {
        this.monster = monster;
        this.row = row;
        this.col = col;
        this.lane = lane;
    }

    public Monster getMonster() { return monster; }
    public int getRow() { return row; }
    public int getCol() { return col; }
    public int getLane() { return lane; }

    public void setPos(int r, int c) { this.row = r; this.col = c; }
}
