package org.roehampton.sad_project.sad_stock_price_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.roehampton.sad_project.sad_stock_price_app.model.*;
import org.roehampton.sad_project.sad_stock_price_app.data.StockDataProvider;
import org.roehampton.sad_project.sad_stock_price_app.data.SQLiteStorage;
import org.roehampton.sad_project.sad_stock_price_app.data.YahooFinance;
import org.roehampton.sad_project.sad_stock_price_app.ui.ChartDisplay;
import org.roehampton.sad_project.sad_stock_price_app.ui.UserPortfolio;
import org.roehampton.sad_project.sad_stock_price_app.ui.Watchlist;

/**
 * MainController handles UI interactions and integrates key components like Watchlist, UserPortfolio, and ChartDisplay.
 */
public class MainController {
    @FXML
    private TextField stockSymbolField;
    @FXML
    private Label stockPriceLabel;

    private final Watchlist watchlist;
    private final UserPortfolio userPortfolio;
    private final ChartDisplay chartDisplay;
    private final IStockDataProvider stockDataProvider;

    public MainController() {
        // Initialize dependencies
        this.watchlist = new Watchlist();
        this.userPortfolio = new UserPortfolio();
        this.chartDisplay = new ChartDisplay();

        // Dependency Injection for stock data retrieval
        this.stockDataProvider = new StockDataProvider(new SQLiteStorage(), new YahooFinance());
    }

    /**
     * Fetches stock price, updates UI, adds to watchlist, and visualizes data.
     */
    @FXML
    public void fetchStockPrice() {
        String symbol = stockSymbolField.getText().trim();

        if (!symbol.isEmpty()) {
            double price = stockDataProvider.provideStockData(symbol);

            // Update UI with stock price
            stockPriceLabel.setText("Price: $" + price);

            // Logically use Watchlist, UserPortfolio, and ChartDisplay
            watchlist.addStock(symbol);
            userPortfolio.addInvestment(symbol, 10); // Assume 10 shares for example
            chartDisplay.visualizeStockData(symbol, price);
        } else {
            stockPriceLabel.setText("Enter a valid stock symbol.");
        }
    }
}
