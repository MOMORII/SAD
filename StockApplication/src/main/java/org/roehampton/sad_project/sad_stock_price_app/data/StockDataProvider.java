package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockData;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockDataProvider;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockAPI;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataStorage;

/**
 * StockDataProvider fetches data from an IStockAPI (e.g., AlphavantageAPI) and stores it via IDataStorage (e.g., PersistentStorage).
 *
 * SOLID:
 *  - Single Responsibility: Retrieves and stores stock data, no UI or portfolio management here.
 *  - Open/Closed: We can swap out IStockAPI or IDataStorage with new implementations.
 *  - Dependency Inversion: Depends on abstractions (IStockAPI, IDataStorage) rather than concrete classes.
 *
 * SOA:
 *  - Another small "service" that orchestrates retrieval (API) and storage.
 */

public class StockDataProvider implements IStockDataProvider {
    private final IDataStorage storage;
    private final IStockAPI api;

    public StockDataProvider(IDataStorage storage, IStockAPI api) {
        this.storage = storage;
        this.api = api;
    }

    @Override
    public double provideStockData(String symbol) {
        double price;
        try {
            price = api.getStockPrice(symbol);
        } catch (Exception e) {
            // fallback
            if (storage instanceof IStockData) {
                price = ((IStockData) storage).retrieveStockData(symbol);
            } else {
                throw new IllegalStateException("Storage does not support retrieval");
            }
        }
        storage.saveStockData(symbol, price);
        return price;
    }
}
