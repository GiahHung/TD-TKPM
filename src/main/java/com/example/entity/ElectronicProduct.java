package com.example.entity;

import java.util.List;

public class ElectronicProduct extends Product{
    private int baoHanh; // Warranty period
    private int congSuat; // Power rating


    public ElectronicProduct(int maMh, String name, int price, String category, int quantity,String dvt, int baoHanh, int congSuat) {
        super(maMh, name, price, category, quantity,dvt);
        this.baoHanh = baoHanh;
        this.congSuat = congSuat;
    }

    // Getters
    public int getBaoHanh() { return baoHanh; }
    public int getCongSuat() { return congSuat; }

    @Override
    public int totalQuantity() {
      
        return getQuantity();
    }
}
