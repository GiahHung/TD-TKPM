package com.example.entity;

import java.util.List;

public abstract class Product {
    private int maMh; 
    private String name; 
    private int price;
    private String category; 
    private int quantity; 
    private String dvt;

    public Product(int maMh, String name, int price, String category, int quantity,String dvt) {
        this.maMh = maMh;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.dvt = dvt;
    }

public abstract int totalQuantity(List<Product> productData);
    public int getMaMh() { return maMh; }
    public String getName() { return name; }
    public int getPrice() { return price; }
    public String getCategory() { return category; }
    public int getQuantity() { return quantity; }
    public String getDvt() {
        return dvt;
    }
}
