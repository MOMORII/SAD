package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for retrieving stock data.
 */
public interface IDataRetrieval {
    double retrieveStockPrice(String symbol);
}
