package org.roehampton.sad_project.sad_stock_price_app.data;

import org.json.JSONObject;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockAPI;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * AlphavantageAPI is responsible for calling Alpha Vantage API to retrieve the latest stock price.
 *
 * SOLID:
 * - Single Responsibility: Only handles API communication and parsing.
 * - Dependency Inversion: Implements IStockAPI interface, making it interchangeable.
 *
 * SOA:
 * - Independent "service" for fetching external API data.
 */
public class AlphavantageAPI implements IStockAPI {

    private static final String API_KEY = "3E457SNRLJ0OCABB";  // Replace with your actual API key

    @Override
    public double getStockPrice(String symbol) {
        try {
            // Construct the API URL
            String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + API_KEY;
            HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            // Parse the JSON response
            JSONObject jsonResponse = new JSONObject(response.toString());
            if (jsonResponse.has("Error Message") || jsonResponse.has("Note")) {
                throw new Exception("API Error: " + jsonResponse.optString("Error Message", jsonResponse.optString("Note")));
            }

            JSONObject timeSeries = jsonResponse.getJSONObject("Time Series (Daily)");
            String latestDate = timeSeries.keys().next();  // Get the latest available date
            JSONObject latestData = timeSeries.getJSONObject(latestDate);
            double closingPrice = latestData.getDouble("4. close");  // Extract the closing price

            return closingPrice;  // Return the latest stock price
        } catch (Exception e) {
            System.out.println("Error fetching stock price for " + symbol + ": " + e.getMessage());
            return -1;  // Return -1 in case of error
        }
    }

    @Override
    public String getHistoricalData(String symbol) {
        try {
            // Construct the API URL
            String urlString = "https://www.alphavantage.co/query?function=TIME_SERIES_DAILY&symbol=" + symbol + "&apikey=" + API_KEY;
            HttpURLConnection con = (HttpURLConnection) new URL(urlString).openConnection();
            con.setRequestMethod("GET");

            BufferedReader in = new BufferedReader(new InputStreamReader(con.getInputStream()));
            StringBuilder response = new StringBuilder();
            String line;
            while ((line = in.readLine()) != null) {
                response.append(line);
            }
            in.close();

            return response.toString();  // Return raw historical data as JSON string
        } catch (Exception e) {
            System.out.println("Error fetching historical data for " + symbol + ": " + e.getMessage());
            return "Error: " + e.getMessage();
        }
    }

    @Override
    public String getStockNews(String symbol) {
        // This can be expanded with a real stock news API if necessary.
        return "Mock stock news for " + symbol;  // For now, we are returning a mock response
    }
}