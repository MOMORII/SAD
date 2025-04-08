package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for fetching stock prices from an API.
 */

public interface IStockAPI {

    double getStockPrice(String symbol);  // Fetch the latest stock price

    String getHistoricalData(String symbol);  // Fetch historical stock data

    String getStockNews(String symbol);  // Fetch stock-related news (optional for now)
}
