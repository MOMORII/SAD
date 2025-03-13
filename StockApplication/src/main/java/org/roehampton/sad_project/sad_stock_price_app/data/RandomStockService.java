package org.roehampton.sad_project.sad_stock_price_app.data;

import java.util.Random;

public class RandomStockService implements Stock {
    private final Random random = new Random();

    @Override
    public StockPrice fetchStock(String symbol) {
        double price = 50 + (random.nextDouble() * 100);
        return new StockPrice(symbol, price);
    }
}
