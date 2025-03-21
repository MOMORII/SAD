package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for visualizing stock data.
 */
public interface IDataVisualisation {
    void visualizeStockData(String symbol, double price);
}
