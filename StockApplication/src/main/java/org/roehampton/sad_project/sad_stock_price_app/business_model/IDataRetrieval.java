package org.roehampton.sad_project.sad_stock_price_app.business_model;

/**
 * Interface for retrieving stock data.
 * SOLID:
 *  - Interface Segregation Principle (ISP): This interface has a single method,
 *    so implementers only provide one responsibility (retrieveStockPrice).
 * SOA:
 *  - Defines a contract for a "data retrieval service" in a service-oriented design.
 */
/**
 * Interface for retrieving stock price data from storage.
 */
public interface IDataRetrieval {
    double retrieveStockPrice(String symbol);
}