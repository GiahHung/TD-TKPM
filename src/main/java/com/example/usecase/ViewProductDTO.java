package com.example.usecase;


public class ViewProductDTO {
    
    private String name;
    private double price;
    private int maMh;
    private int quantity;
    private String dvt;
    private String category;
   
    public ViewProductDTO(String name, double price, int maMh, int quantity, String dvt, String category) {
        this.name = name;
        this.price = price;
        this.maMh = maMh;
        this.quantity = quantity;
        this.dvt = dvt;
        this.category = category;
       
    }

    public String getName() {
        return name;
    }

    public double getPrice() {
        return price;
    }

    public int getMaMh() {
        return maMh;
    }

    public int getQuantity() {
        return quantity;
    }

    public String getDvt() {
        return dvt;
    }

    public String getCategory() {
        return category;
    }

   
    

   
    
}
