package org.roehampton.sad_project.sad_stock_price_app.UI;

import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public interface IDataRetrieval {
    stockPrice[] getHistoricalPrices(String symbol);
}