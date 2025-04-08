package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockPrice;
import org.roehampton.sad_project.sad_stock_price_app.ui.ChartDisplay;

/**
 * StockPrice handles stock data logic and delegates rendering to ChartDisplay.
 *
 * SOLID:
 *  - Single Responsibility (SRP): Only fetch (simulated) price and update chart.
 *  - Open/Closed Principle (OCP): If the calculation or data source changes, we don't need
 *    to modify how the chart is displayed (ChartDisplay is separate).
 *  - Dependency Inversion (DIP): Instantiated with a ChartDisplay reference; can easily accept
 *    any class that fits that role (e.g., a different chart or a logger).
 *
 * SOA:
 *  - Acts like a "pricing service" that the UI (MainController) can call.
 */
public class StockPrice implements IStockPrice {

    private final ChartDisplay chartDisplay;

    public StockPrice(ChartDisplay chartDisplay) {
        this.chartDisplay = chartDisplay;
    }

    public void showPrice(String stockSymbol, double price) {
        System.out.println("Price of " + stockSymbol + ": " + price);
        chartDisplay.displayChart(stockSymbol, price);
    }

    @Override
    public double getStockPrice(String symbol) {
        return 0;
    }
}
