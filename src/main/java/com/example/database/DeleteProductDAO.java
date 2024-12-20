package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entity.Product;
import com.example.usecase.deleteProduct.DeleteDatabaseBoundary;
import com.example.usecase.deleteProduct.DeleteInputDTO;

public class DeleteProductDAO implements DeleteDatabaseBoundary {

    @Override
    public void delete(int mamh) {
          String sql = "DELETE FROM product WHERE MaMh = ?";
        
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, mamh);
            preparedStatement.executeUpdate();
            System.out.println("Product deleted successfully.");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean checkProduct(int mamh) {
         String sql = "SELECT COUNT(*) FROM product WHERE MaMh = ?";
        
        try (Connection connection = ConnectDatabase.getConnection();
             PreparedStatement preparedStatement = connection.prepareStatement(sql)) {
             
            preparedStatement.setInt(1, mamh);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                return resultSet.getInt(1) > 0;
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
