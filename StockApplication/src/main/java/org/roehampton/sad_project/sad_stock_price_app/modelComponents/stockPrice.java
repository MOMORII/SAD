package org.roehampton.sad_project.sad_stock_price_app.modelComponents;

public record stockPrice(String symbol, double price) {
    public String getSymbol() {
        return symbol;
    }

    public double getPrice() {
        return price;
    }
}


