package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for retrieving stored stock data.
 */
public interface IStockData {
    double retrieveStockData(String symbol);
}
