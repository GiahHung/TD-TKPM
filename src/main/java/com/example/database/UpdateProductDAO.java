package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Date;

import com.example.entity.CeramicsProduct;
import com.example.entity.ElectronicProduct;
import com.example.entity.FoodProduct;
import com.example.entity.Product;
import com.example.usecase.updateProduct.UpdateDatabaseBoundary;

public class UpdateProductDAO implements UpdateDatabaseBoundary {
 
    @Override
    public int update(Product product) {
        String query = "UPDATE product SET productName = ?, price = ?, categoryKey = ?, sl = ?, dvt = ?, nSX = ?, hSD = ?, BH = ?, nhaSX = ?, nhaCC = ?, NNK = ?, congSuat = ? WHERE mamh = ?";
        int rowsUpdated = 0;  // Declare and initialize rowsUpdated
    
        try (Connection conn = ConnectDatabase.getConnection();
        PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setString(1, product.getName());
            stmt.setInt(2, product.getPrice());
            stmt.setString(3, product.getCategory());
            stmt.setInt(4, product.getQuantity());
            stmt.setString(5, product.getDvt());
            stmt.setInt(13, product.getMaMh());
    
            if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                stmt.setDate(6, new java.sql.Date(foodProduct.getNSX().getTime()));
                stmt.setDate(7, new java.sql.Date(foodProduct.getHSD().getTime()));
                stmt.setNull(8, java.sql.Types.VARCHAR);
                stmt.setNull(9, java.sql.Types.VARCHAR);
                stmt.setString(10, foodProduct.getNhaCungCap());
                stmt.setNull(11, java.sql.Types.DATE);
                stmt.setNull(12, java.sql.Types.VARCHAR);
    
            } else if (product instanceof CeramicsProduct) {
                CeramicsProduct ceramicsProduct = (CeramicsProduct) product;
                stmt.setNull(6, java.sql.Types.DATE);
                stmt.setNull(7, java.sql.Types.DATE);
                stmt.setNull(8, java.sql.Types.VARCHAR);
                stmt.setString(9, ceramicsProduct.getNhaSanXuat());
                stmt.setNull(10, java.sql.Types.VARCHAR);
                stmt.setDate(11, new java.sql.Date(ceramicsProduct.getNgayNhapKho().getTime()));
                stmt.setNull(12, java.sql.Types.VARCHAR);
    
            } else if (product instanceof ElectronicProduct) {
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                stmt.setNull(6, java.sql.Types.DATE);
                stmt.setNull(7, java.sql.Types.DATE);
                stmt.setString(8, electronicProduct.getBaoHanh());
                stmt.setNull(9, java.sql.Types.VARCHAR);
                stmt.setNull(10, java.sql.Types.VARCHAR);
                stmt.setNull(11, java.sql.Types.DATE);
                stmt.setString(12, electronicProduct.getCongSuat());
            }
    
            // Execute the update and return the number of rows updated
            rowsUpdated = stmt.executeUpdate();
    
            if (rowsUpdated == 0) {
                throw new SQLException("No product found with mamh: " + product.getMaMh());
            }
    
        } catch (SQLException e) {
            e.printStackTrace();
            // Optionally, rethrow the exception or handle it as per your application's needs
        }
    
        return product.getMaMh();  // Return the number of rows updated
    }
    @Override
    public boolean checkProduct(Product product) {
        String query = "SELECT COUNT(*) FROM product WHERE mamh = ?";
        try (Connection conn = ConnectDatabase.getConnection();
            PreparedStatement stmt = conn.prepareStatement(query)) {
            stmt.setInt(1, product.getMaMh());  // Assuming mamh is the unique ID for the product
            try (ResultSet rs = stmt.executeQuery()) {
                if (rs.next()) {
                    return rs.getInt(1) > 0;  // Return true if the product exists
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public Product findProduct(int mamh) {
        String sql = "SELECT * FROM product WHERE mamh = ?";
        Product product = null;

        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            
            pstmt.setInt(1, mamh);
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("productName");
                    int price = rs.getInt("price");
                    String category = rs.getString("categoryKey");
                    int quantity = rs.getInt("sl");
                    String dvt = rs.getString("dvt");

                    switch (category.toLowerCase()) {
                        case "food":
                            Date nSX = rs.getDate("nSX");
                            Date hSD = rs.getDate("hSD");
                            String nhaCC = rs.getString("nhaCC");
                            product = new FoodProduct(mamh, name, price, category, quantity, dvt, nSX, hSD, nhaCC);
                            break;
                        case "ceramic":
                            Date ngayNhapKho = rs.getDate("NNK");
                            String nhaSX = rs.getString("nhaSX");
                            product = new CeramicsProduct(mamh, name, price, category, quantity, dvt, ngayNhapKho, nhaSX);
                            break;
                        case "electronic":
                            String baoHanh = rs.getString("BH");
                            String congSuat = rs.getString("congSuat");
                            product = new ElectronicProduct(mamh, name, price, category, quantity, dvt, baoHanh, congSuat);
                            break;
                        default:
                            throw new SQLException("Unknown product category: " + category);
                    }
                }
            }
        } catch (SQLException e) {
            // Use logging instead of printStackTrace for production use
            e.printStackTrace();
        }

        return product;
    }
}
