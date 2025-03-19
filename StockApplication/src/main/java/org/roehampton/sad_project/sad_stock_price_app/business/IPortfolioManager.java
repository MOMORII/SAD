package org.roehampton.sad_project.sad_stock_price_app.business;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import java.util.List;

public interface IPortfolioManager {
    // adds a stock to the user's portfolio
    void addStockToPortfolio(String symbol, double shares);

    // removes a stock from the user's portfolio
    void removeStockFromPortfolio(String symbol);

    // calculates the total value of the user's portfolio
    double calculatePortfolioValue();

    // retrieves all stocks in the portfolio
    List<StockPrice> getPortfolioStocks();
}
