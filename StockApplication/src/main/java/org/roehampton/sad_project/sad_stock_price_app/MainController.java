package org.roehampton.sad_project.sad_stock_price_app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import org.roehampton.sad_project.sad_stock_price_app.fetching.IStockData;
import org.roehampton.sad_project.sad_stock_price_app.fetching.YahooFinance;
import org.roehampton.sad_project.sad_stock_price_app.storage.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.storage.SQLiteDataStorage;

public class MainController {
    @FXML
    private TextField stockSymbolField;
    @FXML
    private Label stockPriceLabel;

    private final IStockData stockService = new YahooFinance(); // Fetches live stock price
    private final IDataStorage storageService = new SQLiteDataStorage(); // Stores fetched stock prices

    @FXML
    public void fetchStock() {
        String symbol = stockSymbolField.getText().toUpperCase();
        if (!symbol.isEmpty()) {
            // Fetch stock price from YahooFinance
            StockPrice stockPrice = stockService.getStock(symbol);

            // Save fetched stock price to storage
            storageService.saveStock(symbol, stockPrice);

            // Display stock price
            displayStockPrice(stockPrice);
        }
    }

    private void displayStockPrice(StockPrice stock) {
        Platform.runLater(() ->
                stockPriceLabel.setText("Stock Price: " + stock.getSymbol() + " = $" + String.format("%.2f", stock.getPrice()))
        );
    }
}
