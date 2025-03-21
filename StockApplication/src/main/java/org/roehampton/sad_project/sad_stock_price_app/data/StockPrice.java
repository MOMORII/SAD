package org.roehampton.sad_project.sad_stock_price_app.data;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataRetrieval;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockAPI;

/**
 * StockPrice retrieves stock prices using an external API.
 */
public class StockPrice implements IDataRetrieval {
    private final IStockAPI stockAPI;

    public StockPrice(IStockAPI stockAPI) {
        this.stockAPI = stockAPI;
    }

    @Override
    public double retrieveStockPrice(String symbol) {
        return stockAPI.getStockPrice(symbol);
    }
}
