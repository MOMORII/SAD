package org.roehampton.sad_project.sad_stock_price_app;

import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import org.roehampton.sad_project.sad_stock_price_app.business.Watchlist;
import org.roehampton.sad_project.sad_stock_price_app.business.UserPortfolio;
import org.roehampton.sad_project.sad_stock_price_app.fetching.IStockData;
import org.roehampton.sad_project.sad_stock_price_app.fetching.YahooFinance;
import org.roehampton.sad_project.sad_stock_price_app.storage.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.storage.SQLiteDataStorage;

// controls interactions between ui and business logic
public class MainController {
    @FXML
    private TextField stockSymbolField;
    @FXML
    private Label stockPriceLabel;

    private final IStockData stockService = new YahooFinance();
    private final IDataStorage storageService = new SQLiteDataStorage();
    private final Watchlist watchlist = new Watchlist();
    private final UserPortfolio portfolio = new UserPortfolio();

    @FXML
    public void fetchStock() {
        String symbol = stockSymbolField.getText().toUpperCase();
        if (!symbol.isEmpty()) {
            StockPrice stockPrice = stockService.getStock(symbol);
            storageService.saveStock(symbol, stockPrice);
            displayStockPrice(stockPrice);
        }
    }

    private void displayStockPrice(StockPrice stock) {
        Platform.runLater(() -> stockPriceLabel.setText(stock.toString()));
    }
}
