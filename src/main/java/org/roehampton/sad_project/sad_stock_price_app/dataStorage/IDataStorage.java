package org.roehampton.sad_project.sad_stock_price_app.dataStorage;

import org.roehampton.sad_project.sad_stock_price_app.dataModel.stockPrice;

// IDataStorage.java
public interface IDataStorage {
    void saveStockPrice(stockPrice stockPrice);
    stockPrice retrieveStockPrice(String tickerSymbol);
}
