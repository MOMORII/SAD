package org.roehampton.sad_project.sad_stock_price_app.data;
import java.sql.*;

public class StockDatabase {

    private static final String URL = "jdbc:sqlite:sad_stocks.db";

    // Create table to store stock prices
    public static void createTable() {
        String createTableSQL = "CREATE TABLE IF NOT EXISTS stock_prices ("
                + "symbol TEXT PRIMARY KEY,"
                + "price REAL,"
                + "timestamp DATETIME DEFAULT CURRENT_TIMESTAMP);";

        try (Connection conn = DriverManager.getConnection(URL);
             Statement stmt = conn.createStatement()) {
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Database error: " + e.getMessage());
        }
    }

    // Save stock price to the database
    public static void saveStockPrice(String symbol, double price) {
        String insertSQL = "INSERT OR REPLACE INTO stock_prices(symbol, price) VALUES(?, ?)";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, symbol);
            pstmt.setDouble(2, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving stock data: " + e.getMessage());
        }
    }

    // Retrieve stock price from the database
    public static double getStockPrice(String symbol) {
        String selectSQL = "SELECT price FROM stock_prices WHERE symbol = ?";

        try (Connection conn = DriverManager.getConnection(URL);
             PreparedStatement pstmt = conn.prepareStatement(selectSQL)) {
            pstmt.setString(1, symbol);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("price");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving stock data: " + e.getMessage());
        }
        return -1;
    }
}
