package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockData;

/**
 * SQLiteStorage implements data storage interfaces for stock data persistence.
 */
public class SQLiteStorage implements IDataStorage, IStockData {
    @Override
    public void saveStockData(String symbol, double price) {
        System.out.println("Saving " + symbol + " at price " + price + " to SQLite DB.");
    }

    @Override
    public double retrieveStockData(String symbol) {
        return Math.random() * 1000; // Simulated retrieval
    }
}