package org.roehampton.sad_project.sad_stock_price_app.business;

import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class UserPortfolio implements IPortfolioManager {
    private final Map<String, Double> portfolio = new HashMap<>();

    @Override
    public void addStockToPortfolio(String symbol, double shares) {
        // adds or updates stock in portfolio
        portfolio.put(symbol, portfolio.getOrDefault(symbol, 0.0) + shares);
    }

    @Override
    public void removeStockFromPortfolio(String symbol) {
        // removes stock from portfolio if it exists
        portfolio.remove(symbol);
    }

    @Override
    public double calculatePortfolioValue() {
        // assumes a fixed price per share for simplicity
        double stockPrice = 100.0;
        return portfolio.values().stream().mapToDouble(shares -> shares * stockPrice).sum();
    }

    @Override
    public List<StockPrice> getPortfolioStocks() {
        // retrieves stock holdings as StockPrice objects
        return portfolio.entrySet().stream()
                .map(entry -> new StockPrice(entry.getKey(), 100.0))
                .collect(Collectors.toList());
    }
}

