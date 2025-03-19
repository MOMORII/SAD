package org.roehampton.sad_project.sad_stock_price_app.storage;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import java.util.HashMap;
import java.util.Map;

// simulates a database for storing stock data
public class SQLiteDataStorage implements IDataStorage {
    private final Map<String, StockPrice> stockDatabase = new HashMap<>();

    @Override
    public StockPrice getStock(String symbol) {
        // retrieves stock price if it exists
        return stockDatabase.get(symbol);
    }

    @Override
    public void saveStock(String symbol, StockPrice stock) {
        // saves stock price to database
        stockDatabase.put(symbol, stock);
        System.out.println("Saving stock price: " + stock);
    }
}
