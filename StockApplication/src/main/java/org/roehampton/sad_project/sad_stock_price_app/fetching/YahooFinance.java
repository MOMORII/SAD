package org.roehampton.sad_project.sad_stock_price_app.fetching;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;

// fetches stock prices from yahoo finance api (simulated)
public class YahooFinance implements IStockData {
    @Override
    public StockPrice getStock(String symbol) {
        // generates random stock price to simulate fetching
        return new StockPrice(symbol, Math.random() * 100 + 50);
    }
}
