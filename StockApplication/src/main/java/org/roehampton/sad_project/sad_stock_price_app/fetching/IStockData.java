package org.roehampton.sad_project.sad_stock_price_app.fetching;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;

public interface IStockData {
    StockPrice getStock(String symbol);
}
