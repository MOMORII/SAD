package org.roehampton.sad_project.sad_stock_price_app.ui;

import javafx.scene.control.Label;


import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import java.util.HashMap;
import java.util.Map;


/**
 * ChartDisplay is responsible for visualizing stock data using JavaFX charts.
 *
 * SOLID:
 *  - Single Responsibility Principle (SRP): Handles only chart rendering logic.
 *  - Open/Closed Principle (OCP): Could easily swap to a PieChart or LineChart without affecting other classes.
 *  - Dependency Inversion Principle (DIP): Higher-level classes rely on an interface (if you had IDataVisualisation) or
 *    the ChartDisplay type, rather than a specific charting method.
 *
 * SOA:
 *  - Acts as a 'visualization service', separate from data retrieval/storage.
 */
public class ChartDisplay extends VBox {
    private final BarChart<String, Number> barChart;
    private final Label errorLabel;
    private final XYChart.Series<String, Number> series;
    private final Map<String, XYChart.Data<String, Number>> stockDataMap;

    public ChartDisplay() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Stock Prices");
        xAxis.setLabel("Stock Symbol");
        yAxis.setLabel("Price");

        barChart.setCategoryGap(50);
        barChart.setBarGap(5);
        yAxis.setAutoRanging(true); // Optional: auto-scale y-axis

        series = new XYChart.Series<>();
        series.setName("Current Price");
        barChart.getData().add(series);

        stockDataMap = new HashMap<>();

        barChart.setCategoryGap(50);
        barChart.setBarGap(5);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(500);

        errorLabel = new Label();
        this.getChildren().addAll(barChart, errorLabel);
    }

    // Called by StockPrice when a stock is selected.
    public void displayChart(String stockSymbol, double price) {
        if (stockDataMap.containsKey(stockSymbol)) {
            // Update the existing bar.
            stockDataMap.get(stockSymbol).setYValue(price);
        } else {
            XYChart.Data<String, Number> data = new XYChart.Data<>(stockSymbol, price);
            series.getData().add(data);
            stockDataMap.put(stockSymbol, data);
        }

        barChart.getData().add(series);
        errorLabel.setText("");// Clear error message if the chart is displayed.

    }

    // Display error message on UI if fetching fails
    public void displayError(String message) {
        errorLabel.setText(message);
    }
}
