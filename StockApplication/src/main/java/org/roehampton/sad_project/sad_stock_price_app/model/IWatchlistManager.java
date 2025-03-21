package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for managing watchlists.
 */
public interface IWatchlistManager {
    void addStock(String symbol);
    void removeStock(String symbol);
}