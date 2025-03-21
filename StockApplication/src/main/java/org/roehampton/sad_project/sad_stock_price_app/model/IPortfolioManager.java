package org.roehampton.sad_project.sad_stock_price_app.model;

/**
 * Interface for managing user investment portfolios.
 */
public interface IPortfolioManager {
    void addInvestment(String symbol, int shares);
    void removeInvestment(String symbol, int shares);
}
