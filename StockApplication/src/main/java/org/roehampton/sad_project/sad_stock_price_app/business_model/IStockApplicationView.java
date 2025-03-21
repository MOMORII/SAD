package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for updating the stock application view.
 */
public interface IStockApplicationView {
    void updateStockPrice(String symbol, double price);
}
