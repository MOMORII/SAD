package org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents;
import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public interface IStockData {
    stockPrice getStockPrice(String symbol);  // Fetches stock price
}