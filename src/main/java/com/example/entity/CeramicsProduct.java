package com.example.entity;
import java.util.*;

public class CeramicsProduct extends Product {
    private String nhaSanXuat; // Manufacturer
    private Date ngayNhapKho; // Date of stock in

    public CeramicsProduct(int maMh, String name, int price, String category, int quantity,String dvt, Date ngayNhapKho, String nhaSanXuat) {
        super(maMh, name, price, category, quantity,dvt);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }

    // Getters
    public String getNhaSanXuat() { return nhaSanXuat; }
    public Date getNgayNhapKho() { return ngayNhapKho; }

    @Override
    public int totalQuantity(List<Product> productData) {
        int totalQuantity = 0;
        for (Product product : productData) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }
}
