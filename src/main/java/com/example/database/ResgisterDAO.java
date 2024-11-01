package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.example.entity.User;
import com.example.usecase.register.ResgisterDataBoundary;

public class ResgisterDAO implements ResgisterDataBoundary{
    private static final String INSERT_PRODUCT_SQL = "INSERT INTO users (username, password) VALUES (?, ?)";
    @Override
    public void register(User user) {
        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_PRODUCT_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, user.getUserName());
            pstmt.setString(2, user.getPassword());
         
            pstmt.executeUpdate();

        } catch (SQLException e) {
            e.printStackTrace();
           
        }
    }
    @Override
    public Boolean checkUserName(User user) {
            String query = "SELECT COUNT(*) FROM users WHERE username = ? ";
        try (Connection conn = ConnectDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUserName());  
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

}
