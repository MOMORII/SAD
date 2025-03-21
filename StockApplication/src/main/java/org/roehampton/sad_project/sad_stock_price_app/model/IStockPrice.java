package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for retrieving stock prices.
 */
public interface IStockPrice {
    double getPrice(String symbol);
}