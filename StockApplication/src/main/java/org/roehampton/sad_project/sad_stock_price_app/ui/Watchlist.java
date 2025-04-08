package org.roehampton.sad_project.sad_stock_price_app.ui;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IWatchlistManager;

/**
 * Watchlist manages a list of tracked stocks.
 *
 * SOLID:
 *  - Single Responsibility: Maintains watchlist (add/remove stock). Doesn't do storage or UI tasks.
 *  - Interface Segregation: Implements only IWatchlistManager's responsibilities.
 *
 * SOA:
 *  - Acts as a small "watchlist service" in the larger architecture.
 */
import java.util.ArrayList;
import java.util.ArrayList;
import java.util.List;

public class Watchlist implements IWatchlistManager {
    private final List<String> watchlist;

    public Watchlist() {
        this.watchlist = new ArrayList<>();  // Initialize the watchlist as an empty list
    }

    @Override
    public void addStock(String symbol) {
        if (!watchlist.contains(symbol)) {
            watchlist.add(symbol);  // Add the symbol to the watchlist
            System.out.println(symbol + " added to watchlist.");
        } else {
            System.out.println(symbol + " is already in the watchlist.");
        }
    }

    @Override
    public void removeStock(String symbol) {
        if (watchlist.contains(symbol)) {
            watchlist.remove(symbol);  // Remove the symbol from the watchlist
            System.out.println(symbol + " removed from watchlist.");
        } else {
            System.out.println(symbol + " not found in the watchlist.");
        }
    }

    @Override
    public List<String> getWatchlist() {
        return new ArrayList<>(watchlist);  // Return a copy of the watchlist
    }
}
