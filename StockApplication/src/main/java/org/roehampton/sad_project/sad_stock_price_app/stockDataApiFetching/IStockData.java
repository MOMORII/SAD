package org.roehampton.sad_project.sad_stock_price_app.stockDataApiFetching;

import org.roehampton.sad_project.sad_stock_price_app.dataModel.stockPrice;

public interface IStockData {
    stockPrice getStockPrice(String $);
}
