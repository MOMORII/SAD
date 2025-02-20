package org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents;

import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public interface IDataStorage {
    void saveStockPrice(String symbol, String price);
    stockPrice getStockPrice(String symbol);
}
