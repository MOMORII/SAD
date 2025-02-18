package org.roehampton.sad_project.sad_stock_price_app.dataStorage;

import org.roehampton.sad_project.sad_stock_price_app.dataModel.stockPrice;

public class SQLiteDataStorage implements IDataStorage {
    private stockPrice storedStockPrice;

    @Override
    public void saveStockPrice(stockPrice stockPrice) {
        this.storedStockPrice = stockPrice;
    }

    @Override
    public stockPrice retrieveStockPrice(String tickerSymbol) {
        return storedStockPrice; // Return the stored stock price
    }
}

