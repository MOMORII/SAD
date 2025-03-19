package org.roehampton.sad_project.sad_stock_price_app.business;

import java.util.List;

public interface IWatchlistManager {
    // adds a stock symbol to the watchlist
    void addToWatchlist(String symbol);

    // removes a stock symbol from the watchlist
    void removeFromWatchlist(String symbol);

    // retrieves all tracked stock symbols
    List<String> getWatchedStocks();
}
