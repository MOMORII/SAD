package org.roehampton.sad_project.sad_stock_price_app.UI;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import java.util.List;

public interface ChartDisplay {
    void displayStockChart(List<StockPrice> stockPrices);
}
