package org.roehampton.sad_project.sad_stock_price_app;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents.IStockData;
import org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents.SQLiteDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.dataStorageAndRetrievalComponents.yahooFinance;
import org.roehampton.sad_project.sad_stock_price_app.modelComponents.stockPrice;

public class MainController {

    @FXML
    private Label stockPriceLabel;

    @FXML
    private TextField stockSymbolInput;

    private final IStockData stockData = new yahooFinance();
    private final IDataStorage storage = new SQLiteDataStorage();

    @FXML
    protected void onFetchStockPrice() {
        System.out.println("Fetch Price button clicked."); // Debugging

        String symbol = stockSymbolInput.getText().toUpperCase();
        if (!symbol.isEmpty()) {
            stockPrice price = stockData.getStockPrice(symbol);
            System.out.println("Retrieved stock: " + price.getSymbol() + " = $" + price.getPrice());

            // Save to storage
            storage.saveStockPrice(symbol, String.valueOf(price.getPrice()));

            // Update UI label
            stockPriceLabel.setText("Stock: " + price.getSymbol() + " | Price: $" + price.getPrice());
        } else {
            stockPriceLabel.setText("Please enter a stock symbol!");
        }
    }
}
