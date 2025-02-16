package org.roehampton.sad_project.sad_stock_price_app.stockDataApiFetching;

import org.roehampton.sad_project.sad_stock_price_app.dataModel.stockPrice;

// YahooFinance.java
public class yahooFinance implements IStockData {
    @Override
    public stockPrice getStockPrice(String tickerSymbol) {
        return new stockPrice(tickerSymbol, Math.random() * 100 + 50); // Simulated price
    }
}