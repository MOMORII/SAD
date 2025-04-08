package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for retrieving stock prices.
 */
public interface IStockPrice {
    /**
     * Method to retrieve the current stock price for a given symbol.
     * @param symbol Stock symbol (e.g., AAPL, TSLA, etc.)
     * @return The current stock price.
     */
    double getStockPrice(String symbol);
}
