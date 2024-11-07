package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import com.example.usecase.getOneProduct.GetOneProductDataBoundary;

public class GetOneProductDAO implements GetOneProductDataBoundary {
    private static final String SELECT_PRODUCTS_QUERY = "SELECT * FROM product WHERE mamh = ?"; 

    @Override
    public Product getOneProduct(int mamh) {
        Product product = null;
        
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {

            // Set the parameter for the query
            preparedStatement.setInt(1, mamh);

            try (ResultSet resultSet = preparedStatement.executeQuery()) {
                if (resultSet.next()) {
                    String productType = resultSet.getString("categoryKey"); // Assuming categoryKey distinguishes product types

                    switch (productType) {
                        case "ceramic": // Example category for ceramic products
                            product = new CeramicsProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getDate("NNK"),
                                resultSet.getString("NhaSX")
                            );
                            break;

                        case "food": // Example category for food products
                            product = new FoodProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getDate("NSX"),
                                resultSet.getDate("HSD"),
                                resultSet.getString("NhaCC")
                            );
                            break;

                        case "electronic": // Example category for electronic products
                            product = new ElectronicProduct(
                                resultSet.getInt("MaMh"), 
                                resultSet.getString("productName"), 
                                resultSet.getInt("price"),
                                resultSet.getString("categoryKey"),
                                resultSet.getInt("SL"),
                                resultSet.getString("DVT"),
                                resultSet.getInt("BH"),
                                resultSet.getInt("congSuat")
                            );
                            break;

                        default:
                            System.err.println("Unknown product type: " + productType);
                            break;
                    }
                }
            }
        } catch (SQLException e) {
            System.err.println("Error fetching product: " + e.getMessage());
        }
        
        return product;
    }
}
