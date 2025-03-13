package org.roehampton.sad_project.sad_stock_price_app.data;

public interface Stock {
    StockPrice fetchStock(String symbol);
}
