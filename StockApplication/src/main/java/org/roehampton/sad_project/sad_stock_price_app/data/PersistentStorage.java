package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockData;

/**
 * PersistentStorage implements data storage interfaces for stock data persistence.
 *
 * SOLID:
 *  - Single Responsibility (SRP): Deals only with saving and retrieving stock data.
 *  - Dependency Inversion (DIP): Higher-level code depends on the IDataStorage interface,
 *    not this concrete class.
 *  - Open/Closed (OCP): Can replace this with another storage mechanism (e.g., MySQL, file, etc.)
 *    without changing the rest of the system.
 *
 * SOA:
 *  - Acts as a "storage service" that can be called by other parts of the application.
 */
public class PersistentStorage implements IDataStorage, IStockData {
    @Override
    public void saveStockData(String symbol, double price) {
        System.out.println("Saving " + symbol + " at price " + price + " to SQLite DB.");
    }

    @Override
    public double retrieveStockData(String symbol) {
        return Math.random() * 1000; // Simulated retrieval
    }
}
