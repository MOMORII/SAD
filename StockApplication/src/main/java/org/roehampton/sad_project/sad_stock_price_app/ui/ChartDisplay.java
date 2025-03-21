package org.roehampton.sad_project.sad_stock_price_app.ui;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataVisualisation;

/**
 * ChartDisplay visualizes stock price data.
 */
public class ChartDisplay implements IDataVisualisation {
    @Override
    public void visualizeStockData(String symbol, double price) {
        System.out.println("Displaying chart for: " + symbol + " - Price: " + price);
    }
}
