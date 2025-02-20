package org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents;

import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public class SQLiteDataStorage implements IDataStorage {
    @Override
    public void saveStockPrice(String symbol, String price) {
        System.out.println("Saving stock price: " + symbol + " = $" + price);
    }

    @Override
    public stockPrice getStockPrice(String symbol) {
        return new stockPrice(symbol, Math.random() * 100 + 50); // Dummy retrieval for testing
    }
}
