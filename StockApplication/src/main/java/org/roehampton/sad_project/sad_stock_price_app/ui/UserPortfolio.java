package org.roehampton.sad_project.sad_stock_price_app.ui;

import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockDataProvider;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IPortfolioManager;
import java.util.HashMap;
import java.util.Map;

/**
 * UserPortfolio manages a collection of stock investments and interacts with the stock data provider.
 *
 * SOLID Principles:
 * - SRP: Responsible solely for portfolio management.
 * - OCP: Supports extensibility without modifying the class (e.g., new calculations).
 * - DIP: Depends on abstraction (IStockDataProvider) for price fetching.
 */
public class UserPortfolio implements IPortfolioManager {
    private final IStockDataProvider stockDataProvider;
    private final Map<String, Integer> portfolio;

    public UserPortfolio(IStockDataProvider stockDataProvider) {
        this.stockDataProvider = stockDataProvider;
        this.portfolio = new HashMap<>();
    }

    @Override
    public void addInvestment(String symbol, int shares) {
        if (shares <= 0) {
            System.out.println("Cannot add non-positive shares.");
            return;
        }
        portfolio.merge(symbol, shares, Integer::sum);
        System.out.println("✅ Added " + shares + " shares of " + symbol + " to portfolio.");
    }

    @Override
    public void removeInvestment(String symbol, int shares) {
        if (!portfolio.containsKey(symbol)) {
            System.out.println("⚠️ No investment found for " + symbol);
            return;
        }
        int currentShares = portfolio.get(symbol);
        if (shares >= currentShares) {
            portfolio.remove(symbol);
            System.out.println("🗑 Removed all shares of " + symbol);
        } else {
            portfolio.put(symbol, currentShares - shares);
            System.out.println("➖ Removed " + shares + " shares of " + symbol);
        }
    }

    public double calculateTotalValue() {
        double total = 0;
        for (Map.Entry<String, Integer> entry : portfolio.entrySet()) {
            try {
                double price = stockDataProvider.provideStockData(entry.getKey());
                total += price * entry.getValue();
            } catch (Exception e) {
                System.out.println("❌ Failed to retrieve price for " + entry.getKey() + ": " + e.getMessage());
            }
        }
        return total;
    }

    public Map<String, Integer> getInvestments() {
        return new HashMap<>(portfolio); // Return a copy to prevent external mutation
    }
}
