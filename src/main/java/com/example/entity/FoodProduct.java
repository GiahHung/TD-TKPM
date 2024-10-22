package com.example.entity;
import java.util.*;

public class FoodProduct extends Product{
    private Date nSX; // Manufacturing date
    private Date hSD; // Expiration date
    private String nhaCungCap; // Supplier name

    public FoodProduct(int maMh, String name, int price, String category, int quantity,String dvt, Date nSX, Date hSD, String nhaCungCap) {
        super(maMh, name, price, category, quantity, dvt);
        this.nSX = nSX;
        this.hSD = hSD;
        this.nhaCungCap = nhaCungCap;
    }

    // Getters
    public Date getNSX() { return nSX; }
    public Date getHSD() { return hSD; }
    public String getNhaCungCap() { return nhaCungCap; }

    @Override
    public int totalQuantity(List<Product> productData) {
        int totalQuantity = 0;
        for (Product product : productData) {
            totalQuantity += product.getQuantity();
        }
        return totalQuantity;
    }
}
