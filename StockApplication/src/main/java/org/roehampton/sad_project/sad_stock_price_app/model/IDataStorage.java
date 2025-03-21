package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for data storage operations.
 */
public interface IDataStorage {
    void saveStockData(String symbol, double price);
}
