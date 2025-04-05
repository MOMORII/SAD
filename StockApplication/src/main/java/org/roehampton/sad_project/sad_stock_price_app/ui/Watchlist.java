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
public class Watchlist implements IWatchlistManager {
    @Override
    public void addStock(String symbol) {
        System.out.println(symbol + " added to watchlist.");
    }

    @Override
    public void removeStock(String symbol) {
        System.out.println(symbol + " removed from watchlist.");
    }
}
