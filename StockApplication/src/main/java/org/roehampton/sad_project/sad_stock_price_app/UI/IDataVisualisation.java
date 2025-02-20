package org.roehampton.sad_project.sad_stock_price_app.UI;
import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

import java.util.List;

public interface IDataVisualisation {
    void displayStockChart(List<stockPrice> stockPrices);
}
