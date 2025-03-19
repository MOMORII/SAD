package org.roehampton.sad_project.sad_stock_price_app.business;

import java.util.ArrayList;
import java.util.List;

public class Watchlist implements IWatchlistManager {
    private final List<String> watchlist = new ArrayList<>();

    @Override
    public void addToWatchlist(String symbol) {
        // adds stock symbol to watchlist if it's not already there
        if (!watchlist.contains(symbol)) {
            watchlist.add(symbol);
        }
    }

    @Override
    public void removeFromWatchlist(String symbol) {
        // removes stock symbol from watchlist
        watchlist.remove(symbol);
    }

    @Override
    public List<String> getWatchedStocks() {
        // returns list of tracked stock symbols
        return new ArrayList<>(watchlist);
    }
}
