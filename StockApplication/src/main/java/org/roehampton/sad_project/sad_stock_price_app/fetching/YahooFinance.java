package org.roehampton.sad_project.sad_stock_price_app.fetching;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;

public class YahooFinance implements IStockData {
    @Override
    public StockPrice getStock(String symbol) {

        return new StockPrice(symbol, Math.random() * 100 + 50);
    }
}
