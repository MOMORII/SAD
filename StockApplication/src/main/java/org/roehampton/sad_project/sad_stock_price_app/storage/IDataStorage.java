package org.roehampton.sad_project.sad_stock_price_app.storage;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;

public interface IDataStorage {
    StockPrice getStock(String symbol);
    void saveStock(String symbol, StockPrice stock);
}
