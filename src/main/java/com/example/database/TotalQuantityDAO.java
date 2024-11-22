package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.usecase.totalQuantity.TotalQuantityDatabaseBoundary;

public class TotalQuantityDAO implements TotalQuantityDatabaseBoundary {
    private static final String SELECT_PRODUCTS_QUERY = "SELECT SUM(SL) AS totalQuantity FROM product WHERE categoryKey = ?";

    @Override
    public int getTotalQuantity(String categories) {
        int totalQuantity = 0;
    
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {
    
            preparedStatement.setString(1, categories);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    totalQuantity = resultSet.getInt("totalQuantity");
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching total quantity: " + e.getMessage());
        }
    
        return totalQuantity;
    }
}
