package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockAPI;

/**
 * YahooFinance simulates retrieving real-time stock prices from an external API.
 *
 * SOLID:
 *  - Single Responsibility: Provides the getStockPrice() method for fetching (simulated) data.
 *  - Dependency Inversion: Higher-level modules use IStockAPI, not this concrete class directly.
 *
 * SOA:
 *  - Represents an external "API service" that could be replaced with a real HTTP call.
 */
public class YahooFinance implements IStockAPI {
    @Override
    public double getStockPrice(String symbol) {
        return Math.random() * 1000; // Simulated API response
    }
}
