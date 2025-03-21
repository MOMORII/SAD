package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockDataProvider;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockAPI;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataStorage;

/**
 * StockDataProvider fetches data from YahooFinance and stores it using SQLiteStorage.
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
        double price = api.getStockPrice(symbol);
        storage.saveStockData(symbol, price);
        return price;
    }
}