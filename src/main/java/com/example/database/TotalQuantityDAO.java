package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import java.util.stream.Collectors;
import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import com.example.usecase.totalQuantity.TotalQuantityDatabaseBoundary;

public class TotalQuantityDAO implements TotalQuantityDatabaseBoundary {
    private static final String SELECT_PRODUCTS_QUERY = "SELECT * FROM product WHERE categoryKey =? "; 
    @Override
    public List<Product> getQuantityList(String categories) {
        List<Product> products = new ArrayList<>();

        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {
             preparedStatement.setString(1, categories);
            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                while (resultSet.next()) {

                    switch (categories) {
                        case "ceramic":
                            products.add(new CeramicsProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getDate("NNK"),
                                resultSet.getString("NhaSX")
                            ));
                            break;

                        case "food":
                            products.add(new FoodProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getDate("NSX"),
                                resultSet.getDate("HSD"),
                                resultSet.getString("NhaCC")
                            ));
                            break;

                        case "electronic":
                            products.add(new ElectronicProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getInt("BH"),
                                resultSet.getInt("congSuat")
                            ));
                            break;

                        default:
                            System.err.println("Unknown product type: " + categories);
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product list: " + e.getMessage());
        }
        return products;
    }
}
