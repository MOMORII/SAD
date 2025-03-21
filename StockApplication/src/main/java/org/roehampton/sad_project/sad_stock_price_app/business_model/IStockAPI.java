package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for fetching stock prices from an API.
 */
public interface IStockAPI {
    double getStockPrice(String symbol);
}