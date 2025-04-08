/**
    NEEDS TO ACT AS A 'PERSISTENT STORAGE' THAT STORES INFORMATION TO A DATABASE, RATHER THAN PRINTING IT OUT TO THE TERMINAL
    ^^ The product owner needds this to be fixed asap.
**/

package org.roehampton.sad_project.sad_stock_price_app.data;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IDataStorage;
import org.roehampton.sad_project.sad_stock_price_app.business_model.IStockData;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
/*
 * PersistentStorage implements data storage interfaces for stock data persistence.
 * SOLID:
 *  - Single Responsibility (SRP): Deals only with saving and retrieving stock data.
 *  - Dependency Inversion (DIP): Higher-level code depends on the IDataStorage interface,
 *    not this concrete class.
 *  - Open/Closed (OCP): Can replace this with another storage mechanism (e.g., MySQL, file, etc.)
 *    without changing the rest of the system.
 * SOA:
 *  - Acts as a "storage service" that can be called by other parts of the application.
 */
import java.sql.*;

public class PersistentStorage implements IDataStorage, IStockData {
    private static final String DB_URL = "jdbc:sqlite:sad_stock.sqlite";

    public PersistentStorage() {
        try (Connection conn = DriverManager.getConnection(DB_URL)) {
            String createTableSQL = "CREATE TABLE IF NOT EXISTS stock_history ("
                    + "symbol TEXT NOT NULL,"
                    + "date TEXT NOT NULL,"
                    + "close_price REAL NOT NULL,"
                    + "PRIMARY KEY (symbol, date));";
            Statement stmt = conn.createStatement();
            stmt.execute(createTableSQL);
        } catch (SQLException e) {
            System.out.println("Error initializing DB: " + e.getMessage());
        }
    }

    @Override
    public void saveStockData(String symbol, double price) {
        String insertSQL = "INSERT OR REPLACE INTO stock_history (symbol, date, close_price) VALUES (?, ?, ?)";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(insertSQL)) {
            pstmt.setString(1, symbol);
            pstmt.setString(2, getCurrentDate());
            pstmt.setDouble(3, price);
            pstmt.executeUpdate();
        } catch (SQLException e) {
            System.out.println("Error saving stock data: " + e.getMessage());
        }
    }

    @Override
    public double retrieveStockData(String symbol) {
        String querySQL = "SELECT close_price FROM stock_history WHERE symbol = ? ORDER BY date DESC LIMIT 1";
        try (Connection conn = DriverManager.getConnection(DB_URL);
             PreparedStatement pstmt = conn.prepareStatement(querySQL)) {
            pstmt.setString(1, symbol);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                return rs.getDouble("close_price");
            }
        } catch (SQLException e) {
            System.out.println("Error retrieving stock data: " + e.getMessage());
        }
        return -1; // No data found
    }

    private String getCurrentDate() {
        java.text.SimpleDateFormat sdf = new java.text.SimpleDateFormat("yyyy-MM-dd");
        return sdf.format(new java.util.Date());
    }
}
