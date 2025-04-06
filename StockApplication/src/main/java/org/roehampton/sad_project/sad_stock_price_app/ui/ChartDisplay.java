package org.roehampton.sad_project.sad_stock_price_app.ui;

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
 *  - Acts as  'visualization service', separate from data retrieval/storage.
 */
public class ChartDisplay extends VBox {

    private final BarChart<String, Number> barChart;
    private final Map<String, XYChart.Data<String, Number>> stockDataMap;

    public ChartDisplay() {
        CategoryAxis xAxis = new CategoryAxis();
        NumberAxis yAxis = new NumberAxis();
        barChart = new BarChart<>(xAxis, yAxis);
        barChart.setTitle("Stock Prices");
        xAxis.setLabel("Stock Symbol");
        yAxis.setLabel("Price");

        stockDataMap = new HashMap<>();

        barChart.setCategoryGap(50);
        barChart.setBarGap(5);
        yAxis.setAutoRanging(false);
        yAxis.setLowerBound(0);
        yAxis.setUpperBound(500);

        this.getChildren().add(barChart);
    }

    public void displayChart(String stockSymbol, double price) {

        if (stockDataMap.containsKey(stockSymbol)) {

            XYChart.Data<String, Number> dataPoint = stockDataMap.get(stockSymbol);
            dataPoint.setYValue(price);
        } else {

            XYChart.Series<String, Number> series = new XYChart.Series<>();
            series.setName(stockSymbol);

            XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(stockSymbol, price);
            series.getData().add(dataPoint);

            barChart.getData().add(series);


            stockDataMap.put(stockSymbol, dataPoint);
        }
    }
}