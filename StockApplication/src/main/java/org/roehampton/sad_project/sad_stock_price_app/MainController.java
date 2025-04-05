package org.roehampton.sad_project.sad_stock_price_app;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import org.roehampton.sad_project.sad_stock_price_app.ui.ChartDisplay;

/**
 * MainController handles UI logic and coordinates actions between the UI (FXML elements)
 * and the data/logic layers (StockPrice, ChartDisplay).
 *
 * SOLID:
 *  - Single Responsibility Principle (SRP): Only manages UI events and updates labels/charts.
 *  - Dependency Inversion Principle (DIP): Depends on StockPrice/ChartDisplay abstractions, not direct internals.
 *  - Interface Segregation: Interacts only with the needed methods (e.g., showPrice()).
 *
 * SOA:
 *  - Acts as an "orchestrator" service for the UI, calling other services (ChartDisplay, StockPrice).
 *  - Minimizes tight coupling by delegating logic to separate service-like classes.
 */
public class MainController {

    @FXML
    private TextField stockSymbolField;

    @FXML
    private Label stockPriceLabel;

    @FXML
    private VBox chartContainer;

    private ChartDisplay chartDisplay;
    private StockPrice stockPrice;

    @FXML
    public void initialize() {
        chartDisplay = new ChartDisplay();
        stockPrice = new StockPrice(chartDisplay);
        chartContainer.getChildren().add(chartDisplay);
    }

    @FXML
    public void fetchStockPrice() {
        String symbol = stockSymbolField.getText();
        double price = Math.random() * 1000; // Generate the price once

        // Show it in the label
        stockPriceLabel.setText("Price: " + price);

        // Pass that exact price to StockPrice, so console and chart also match
        stockPrice.showPrice(symbol, price);
    }

}
