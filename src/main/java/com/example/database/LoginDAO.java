package com.example.database;

import java.security.MessageDigest;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Base64;

import com.example.entity.User;
import com.example.usecase.login.LoginDataBoundary;

public class LoginDAO implements LoginDataBoundary{

    @Override
    public Boolean getUser(User user) {
          String query = "SELECT COUNT(*) FROM users WHERE username = ? and password =?";
        try (Connection conn = ConnectDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, user.getUserName());  
            stmt.setString(2, user.getPassword());  // Assuming password is the field name for the password in the database
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
