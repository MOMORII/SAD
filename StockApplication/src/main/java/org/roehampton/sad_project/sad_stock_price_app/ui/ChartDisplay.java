package org.roehampton.sad_project.sad_stock_price_app.ui;

import javafx.scene.chart.BarChart;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.VBox;
import java.util.HashMap;
import java.util.Map;

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

        XYChart.Series<String, Number> series = new XYChart.Series<>();
        XYChart.Data<String, Number> dataPoint = new XYChart.Data<>(stockSymbol, price);
        series.getData().add(dataPoint);
        barChart.getData().clear();
        barChart.getData().add(series);

        stockDataMap.put(stockSymbol, dataPoint);
    }
}
