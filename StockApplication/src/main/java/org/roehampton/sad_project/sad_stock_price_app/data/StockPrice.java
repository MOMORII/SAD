package org.roehampton.sad_project.sad_stock_price_app.data;

// represents stock price information
public class StockPrice {
    private final String symbol;
    private final double price;

    public StockPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }

    @Override
    public String toString() {
        return symbol + ": $" + price;
    }
}
