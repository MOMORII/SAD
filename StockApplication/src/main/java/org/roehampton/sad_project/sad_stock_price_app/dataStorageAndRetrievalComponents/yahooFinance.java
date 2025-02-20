package org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents;

import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public class yahooFinance implements IStockData {
    @Override
    public stockPrice getStockPrice(String symbol) {
        return new stockPrice(symbol, Math.random() * 100 + 50); // Dummy stock price
    }
}
