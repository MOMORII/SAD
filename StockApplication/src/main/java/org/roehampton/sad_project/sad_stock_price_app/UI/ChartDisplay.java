package org.roehampton.sad_project.sad_stock_price_app.UI;

public class ChartDisplay implements IApplicationView {
    @Override
    public void showStockPrice(String symbol, double price) {
        System.out.println("Displaying: " + symbol + " at $" + price);
    }
}
