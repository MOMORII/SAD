package org.roehampton.sad_project.sad_stock_price_app.ui;

import org.roehampton.sad_project.sad_stock_price_app.model.IPortfolioManager;

/**
 * UserPortfolio manages user's stock investments.
 */
public class UserPortfolio implements IPortfolioManager {
    @Override
    public void addInvestment(String symbol, int shares) {
        System.out.println("Added " + shares + " shares of " + symbol + " to portfolio.");
    }

    @Override
    public void removeInvestment(String symbol, int shares) {
        System.out.println("Removed " + shares + " shares of " + symbol + " from portfolio.");
    }
}
