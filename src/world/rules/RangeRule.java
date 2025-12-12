package world.rules;

public class RangeRule {
    public boolean inRange(int r1, int c1, int r2, int c2) {
        return Math.abs(r1 - r2) <= 1 && Math.abs(c1 - c2) <= 1;
    }
}
