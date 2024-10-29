package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.example.entity.FoodProduct;
import com.example.entity.Product;
import com.example.usecase.findProduct.FindProductDatabaseBoundary;

public class FindProductDAO implements FindProductDatabaseBoundary {

    @Override
    public List<Product> getProductListExpired() {
        List<Product> expiredSoonProducts = new ArrayList<>();
        // Modified query to find products expiring within 1 week (7 days)
        String query = "SELECT * FROM product WHERE HSD BETWEEN CURRENT_DATE AND  DATE_ADD(CURRENT_DATE, INTERVAL 7 DAY)";

        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement stmt = conn.prepareStatement(query);
             ResultSet rs = stmt.executeQuery()) {

            while (rs.next()) {
               
                int manh = rs.getInt("MaMh");
                String name = rs.getString("productname");
                Date hsd = rs.getDate("HSD");  // Assuming HSD is the expiration date
                int price = rs.getInt("price");
                int quantity = rs.getInt("SL");
                String category = rs.getString("categorykey");
                String dvt = rs.getString("dvt");
                String ncc = rs.getString("nhaCC");
                Date nsx = rs.getDate("NSX");  // Manufacturing date
                Product product = new FoodProduct(manh, name, price, category, quantity, dvt, nsx, hsd, ncc);
                expiredSoonProducts.add(product);
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return expiredSoonProducts;
    }

}
