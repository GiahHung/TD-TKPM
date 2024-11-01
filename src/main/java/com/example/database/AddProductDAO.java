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
import com.example.usecase.createProduct.AddDatabaseBoundary;

public class AddProductDAO implements AddDatabaseBoundary {

    private static final String INSERT_PRODUCT_SQL = "INSERT INTO product (productName, price, categoryKey, SL, dvt, nSX, hSD, BH, nhaSX, nhaCC, NNK, congSuat) VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?, ?)";
    private static final String SELECT_PRODUCT_SQL = "SELECT * FROM product WHERE mamh = ?";

    @Override
    public int addProduct(Product product) {
        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(INSERT_PRODUCT_SQL, PreparedStatement.RETURN_GENERATED_KEYS)) {
            
            pstmt.setString(1, product.getName());
            pstmt.setDouble(2, product.getPrice());
            pstmt.setString(3, product.getCategory());
            pstmt.setInt(4, product.getQuantity());
            pstmt.setString(5, product.getDvt());

            // Set values based on product type
            if (product instanceof FoodProduct) {
                FoodProduct foodProduct = (FoodProduct) product;
                pstmt.setDate(6, new java.sql.Date(foodProduct.getNSX().getTime()));
                pstmt.setDate(7, new java.sql.Date(foodProduct.getHSD().getTime()));
                pstmt.setNull(8, java.sql.Types.VARCHAR);
                pstmt.setNull(9, java.sql.Types.VARCHAR);
                pstmt.setString(10, foodProduct.getNhaCungCap());
                pstmt.setNull(11, java.sql.Types.DATE);
                pstmt.setNull(12, java.sql.Types.VARCHAR);
            } else if (product instanceof CeramicsProduct) {
                CeramicsProduct ceramicsProduct = (CeramicsProduct) product;
                pstmt.setNull(6, java.sql.Types.DATE);
                pstmt.setNull(7, java.sql.Types.DATE);
                pstmt.setNull(8, java.sql.Types.VARCHAR);
                pstmt.setString(9, ceramicsProduct.getNhaSanXuat());
                pstmt.setNull(10, java.sql.Types.VARCHAR);
                pstmt.setDate(11, new java.sql.Date(ceramicsProduct.getNgayNhapKho().getTime()));
                pstmt.setNull(12, java.sql.Types.VARCHAR);
            } else if (product instanceof ElectronicProduct) {
                ElectronicProduct electronicProduct = (ElectronicProduct) product;
                pstmt.setNull(6, java.sql.Types.DATE);
                pstmt.setNull(7, java.sql.Types.DATE);
                pstmt.setInt(8, electronicProduct.getBaoHanh());
                pstmt.setNull(9, java.sql.Types.VARCHAR);
                pstmt.setNull(10, java.sql.Types.VARCHAR);
                pstmt.setNull(11, java.sql.Types.DATE);
                pstmt.setInt(12, electronicProduct.getCongSuat());
            }

            pstmt.executeUpdate();

            try (ResultSet generatedKeys = pstmt.getGeneratedKeys()) {
                if (generatedKeys.next()) {
                    return generatedKeys.getInt(1); // Return the new product ID
                } else {
                    throw new SQLException("Creating product failed, no ID obtained.");
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
            return -1; // Return -1 if insertion failed
        }
    }

    @Override
    public Product findProduct(int newProductId) {
        Product product = null;

        try (Connection conn = ConnectDatabase.getConnection();
             PreparedStatement pstmt = conn.prepareStatement(SELECT_PRODUCT_SQL)) {
            
            pstmt.setInt(1, newProductId); // Set the product ID
            
            try (ResultSet rs = pstmt.executeQuery()) {
                if (rs.next()) {
                    String name = rs.getString("productName");
                    int price = rs.getInt("price");
                    String category = rs.getString("categoryKey");
                    int quantity = rs.getInt("sl");
                    String dvt = rs.getString("dvt");

                    // Create product based on category
                    if (category.equalsIgnoreCase("food")) {
                        Date nSX = rs.getDate("nSX");
                        Date hSD = rs.getDate("hSD");
                        String ncc = rs.getString("NhaCC");
                        product = new FoodProduct(newProductId, name, price, category, quantity, dvt, nSX, hSD, ncc);
                    } else if (category.equalsIgnoreCase("ceramic")) {
                        Date ngayNhapKho = rs.getDate("NNK");
                        String nhaSanXuat = rs.getString("nhaSX");
                        product = new CeramicsProduct(newProductId, name, price, category, quantity, dvt, ngayNhapKho, nhaSanXuat);
                    } else if (category.equalsIgnoreCase("electronic")) {
                        int baoHanh = rs.getInt("BH");
                        int congSuat = rs.getInt("congSuat");
                        product = new ElectronicProduct(newProductId, name, price, category, quantity, dvt, baoHanh, congSuat);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }

        return product; // Return the product or null if not found
    }
}
