package org.roehampton.sad_project.sad_stock_price_app.business_model;

import java.util.List;

/**
 * Interface for managing watchlists.
 */
public interface IWatchlistManager {
    void addStock(String symbol);
    void removeStock(String symbol);
    List<String> getWatchlist();
}