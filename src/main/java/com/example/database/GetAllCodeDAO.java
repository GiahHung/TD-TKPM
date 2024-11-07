package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.AllCode;
import com.example.usecase.getAllCode.GetAllCodeDataBoundary;

public class GetAllCodeDAO implements GetAllCodeDataBoundary {
    private static final String SELECT_PRODUCTS_QUERY = "SELECT keyMap FROM allcode WHERE type = ?";

    @Override
    public List<AllCode> getAllCodes(String type) {
        List<AllCode> allCodes = new ArrayList<>();

        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {

            // Set the type parameter for the query
            preparedStatement.setString(1, type);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                // Process the result set
                while (resultSet.next()) {
                    String keyMap = resultSet.getString("keyMap");
                    
                    AllCode allCode = new AllCode(keyMap);
                    allCodes.add(allCode);
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching allcode list: " + e.getMessage());
        }
        
        return allCodes;
    }
}
