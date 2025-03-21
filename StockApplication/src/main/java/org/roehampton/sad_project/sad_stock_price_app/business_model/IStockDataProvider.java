package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for stock data providers.
 */
public interface IStockDataProvider {
    double provideStockData(String symbol);
}