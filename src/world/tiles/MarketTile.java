package world.tiles;

import market.*;

public class MarketTile extends Tile {
    private static final long serialVersionUID = 1L;

    private final Market market;

    public MarketTile(Market market) {
        super(true);
        this.market = market;
    }

    @Override
    public char getSymbol() {
        return 'M';
    }

    public Market getMarket() {
        return market;
    }
}

