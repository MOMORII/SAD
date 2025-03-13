package org.roehampton.sad_project.sad_stock_price_app.UI;

import javafx.scene.chart.*;
import javafx.scene.Scene;
import javafx.stage.Stage;
import org.roehampton.sad_project.sad_stock_price_app.data.StockPrice;
import java.util.List;

public class DataVisualization implements ChartDisplay {
    @Override
    public void displayStockChart(List<StockPrice> stockPrices) {
        Stage stage = new Stage();
        stage.setTitle("Stock Price Chart");

        CategoryAxis xAxis = new CategoryAxis();
        xAxis.setLabel("Stock Symbol");

        NumberAxis yAxis = new NumberAxis();
        yAxis.setLabel("Price");

        BarChart<String, Number> barChart = new BarChart<>(xAxis, yAxis);
        XYChart.Series<String, Number> series = new XYChart.Series<>();
        series.setName("Stock Prices");

        for (StockPrice stock : stockPrices) {
            series.getData().add(new XYChart.Data<>(stock.getSymbol(), stock.getPrice()));
        }

        barChart.getData().add(series);
        Scene scene = new Scene(barChart, 800, 500);
        stage.setScene(scene);
        stage.show();
    }
}
