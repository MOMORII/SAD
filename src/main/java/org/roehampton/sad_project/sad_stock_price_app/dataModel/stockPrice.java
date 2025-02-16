package org.roehampton.sad_project.sad_stock_price_app.dataModel;

public class stockPrice {
    private final String symbol;
    private final double price;

    public stockPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
    }

    public String getSymbol() { return symbol; }
    public double getPrice() { return price; }
}
