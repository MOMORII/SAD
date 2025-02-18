package org.roehampton.sad_project.sad_stock_price_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.roehampton.sad_project.sad_stock_price_app.dataModel.stockPrice;
import org.roehampton.sad_project.sad_stock_price_app.dataStorage.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.dataStorage.SQLiteDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.stockDataApiFetching.IStockData;
import org.roehampton.sad_project.sad_stock_price_app.stockDataApiFetching.yahooFinance;
public class MainController {
    private final IStockData stockData = new yahooFinance(); // Add final
    private final IDataStorage dataStorage = new SQLiteDataStorage(); // Add final

    @FXML
    private TextField stockSymbolInput;

    @FXML
    private Button fetchButton;

    @FXML
    private Label stockPriceLabel;

    @FXML
    protected void onFetchButtonClick() {
        String symbol = stockSymbolInput.getText().toUpperCase();
        if (!symbol.isEmpty()) {
            // Fetch new stock price and save it
            stockPrice stockPrice = stockData.getStockPrice(symbol);
            dataStorage.saveStockPrice(stockPrice);

            // Retrieve the saved stock price
            stockPrice retrievedStock = dataStorage.retrieveStockPrice(symbol);

            // Display the retrieved stock price
            stockPriceLabel.setText("Stock: " + retrievedStock.getSymbol() + " | Price: $" + retrievedStock.getPrice());
        } else {
            stockPriceLabel.setText("Please enter a stock symbol!");
        }
    }

}
