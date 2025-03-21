package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.model.IStockAPI;

/**
 * YahooFinance retrieves real-time stock prices from an external API.
 */
public class YahooFinance implements IStockAPI {
    @Override
    public double getStockPrice(String symbol) {
        return Math.random() * 1000; // Simulated API response
    }
}