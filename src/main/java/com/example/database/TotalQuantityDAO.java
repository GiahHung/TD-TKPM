package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;// Assuming ProductType1 represents "Food" category
import com.example.usecase.totalQuantity.TotalQuantityDatabaseBoundary;

public class TotalQuantityDAO implements TotalQuantityDatabaseBoundary {

    private static final String SELECT_PRODUCTS_QUERY = "SELECT * FROM product WHERE categoryKey = ?";

    @Override
    public List<Product> getFoodQuantityList() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {
             
            ps.setString(1, "food"); // Assuming 'food' is the categoryKey for food products
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
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
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching product list: " + e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getCeramicQuantityList() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {
             
            ps.setString(1, "ceramic"); // Assuming 'food' is the categoryKey for food products
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
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
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching product list: " + e.getMessage());
        }
        return products;
    }

    @Override
    public List<Product> getElectronicQuantityList() {
        List<Product> products = new ArrayList<>();
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement ps = connection.prepareStatement(SELECT_PRODUCTS_QUERY)) {
             
            ps.setString(1, "electronic"); // Assuming 'food' is the categoryKey for food products
            try (ResultSet resultSet = ps.executeQuery()) {
                while (resultSet.next()) {
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
                }
            }
        } catch (Exception e) {
            System.err.println("Error fetching product list: " + e.getMessage());
        }
        return products;
    }
}