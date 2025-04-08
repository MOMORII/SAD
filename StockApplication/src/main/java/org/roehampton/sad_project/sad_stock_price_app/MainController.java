package org.roehampton.sad_project.sad_stock_price_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IWatchlistManager;
import org.roehampton.sad_project.sad_stock_price_app.data.*;
import org.roehampton.sad_project.sad_stock_price_app.ui.ChartDisplay;

/*
 * MainController handles UI logic and coordinates actions between the UI (FXML elements)
 * and the data/logic layers (StockPrice, ChartDisplay).

 * SOLID:
 *  - Single Responsibility Principle (SRP): Only manages UI events and updates labels/charts.
 *  - Dependency Inversion Principle (DIP): Depends on StockPrice/ChartDisplay abstractions, not direct internals.
 *  - Interface Segregation: Interacts only with the needed methods (e.g., showPrice()).
 * SOA:
 *  - Acts as an "orchestrator" service for the UI, calling other services (ChartDisplay, StockPrice).
 *  - Minimizes tight coupling by delegating logic to separate service-like classes.
 */
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockDataProvider;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IPortfolioManager;
import org.roehampton.sad_project.sad_stock_price_app.ui.UserPortfolio;

import java.util.Map;


public class MainController {

    @FXML
    private TextField stockSymbolField;

    @FXML
    private Label stockPriceLabel;
    @FXML
    private Button addStockButton;

    @FXML
    private Button removeStockButton;

    @FXML
    private ListView<String> watchlistView;

    private IWatchlistManager watchlistManager;

    @FXML
    private VBox chartContainer;
    @FXML
    private Label watchlistLabel;

    @FXML
    private VBox watchlistContainer;

    @FXML private TextField portfolioSymbolField;
    @FXML private TextField portfolioSharesField;
    @FXML private Label portfolioMessageLabel;
    @FXML private VBox portfolioContainer;
    @FXML private Label portfolioTotalValueLabel;

    private UserPortfolio userPortfolio;
    private UserPortfolio portfolio;




    private ChartDisplay chartDisplay;
    private StockPrice stockPrice;
    private IStockDataProvider dataProvider;
    private IPortfolioManager portfolioManager;


    @FXML
    public void initialize() {
        portfolio = new UserPortfolio(dataProvider);
        //watchlistManager = new WatchlistManager();

        chartDisplay = new ChartDisplay();
        stockPrice = new StockPrice(chartDisplay);
        chartContainer.getChildren().add(chartDisplay);

        PersistentStorage storage = new PersistentStorage();
        AlphavantageAPI api = new AlphavantageAPI();
        dataProvider = new StockDataProvider(storage, api);
        addStockButton.setOnAction(e -> addStockToWatchlist());
        removeStockButton.setOnAction(e -> removeStockFromWatchlist());




        userPortfolio = new UserPortfolio(dataProvider); // 🔗 Hooked here
        updateWatchlistUI();

    }

    @FXML
    public void showPortfolioTotal() {
        double total = portfolio.calculateTotalValue();
        stockPriceLabel.setText("📊 Portfolio Value: $" + String.format("%.2f", total));
    }

    @FXML
    public void fetchStockPrice() {
        String symbol = stockSymbolField.getText().trim().toUpperCase();
        if (symbol.isEmpty() || !symbol.matches("[A-Z]+")) {
            stockPriceLabel.setText("Invalid input. Enter a valid stock symbol.");
            return;
        }

        double price = dataProvider.provideStockData(symbol);
        if (price == -1) {
            stockPriceLabel.setText("Error fetching stock price.");
            return;
        }

        stockPriceLabel.setText("Price: $" + price);
        stockPrice.showPrice(symbol, price);
    }

    @FXML
    public void addToPortfolio() {
        String symbol = portfolioSymbolField.getText().trim().toUpperCase();
        String sharesText = portfolioSharesField.getText().trim();

        try {
            int shares = Integer.parseInt(sharesText);
            if (shares <= 0) throw new NumberFormatException();

            portfolioManager.addInvestment(symbol, shares);
            portfolioMessageLabel.setText("Added " + shares + " shares of " + symbol + ".");
        } catch (NumberFormatException e) {
            portfolioMessageLabel.setText("Please enter a valid number of shares.");
        }
    }


    @FXML
    public void removeFromPortfolio() {
        String symbol = portfolioSymbolField.getText().trim().toUpperCase();
        String sharesText = portfolioSharesField.getText().trim();

        try {
            int shares = Integer.parseInt(sharesText);
            if (shares <= 0) throw new NumberFormatException();

            portfolioManager.removeInvestment(symbol, shares);
            portfolioMessageLabel.setText("Removed " + shares + " shares of " + symbol + ".");
        } catch (NumberFormatException e) {
            portfolioMessageLabel.setText("Please enter a valid number of shares.");
        }
    }

    private void updatePortfolioUI() {
        portfolioContainer.getChildren().clear();
        Map<String, Integer> investments = userPortfolio.getInvestments();
        double totalValue = userPortfolio.calculateTotalValue();  // Corrected method name

        for (Map.Entry<String, Integer> entry : investments.entrySet()) {
            String symbol = entry.getKey();
            int shares = entry.getValue();
            double price = dataProvider.provideStockData(symbol);
            Label stockInfo = new Label(symbol + ": " + shares + " shares @ $" + price + " = $" + (shares * price));
            portfolioContainer.getChildren().add(stockInfo);
        }

        portfolioTotalValueLabel.setText("Total Value: $" + String.format("%.2f", totalValue));
    }


    @FXML
    public void addStockToWatchlist() {
        String symbol = stockSymbolField.getText().trim().toUpperCase();
        if (symbol.isEmpty() || !symbol.matches("[A-Z]+")) {
            watchlistLabel.setText("Invalid input. Enter a valid stock symbol.");
            return;
        }

        watchlistManager.addStock(symbol);
        updateWatchlistUI();
    }

    @FXML
    public void removeStockFromWatchlist() {
        String symbol = stockSymbolField.getText().trim().toUpperCase();
        if (symbol.isEmpty() || !symbol.matches("[A-Z]+")) {
            watchlistLabel.setText("Invalid input. Enter a valid stock symbol.");
            return;
        }

        watchlistManager.removeStock(symbol);
        updateWatchlistUI();
    }

    private void updateWatchlistUI() {
        // Check if the watchlistManager is null (shouldn't be if initialize() is called properly)
        if (watchlistManager != null) {
            StringBuilder watchlistString = new StringBuilder();
            for (String symbol : watchlistManager.getWatchlist()) {
                watchlistString.append(symbol).append("\n");
            }
            watchlistLabel.setText("Watchlist:\n" + watchlistString.toString());
        } else {
            watchlistLabel.setText("Watchlist manager not initialized.");
        }
    }
}