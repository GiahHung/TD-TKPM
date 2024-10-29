package com.example.usecase.findProduct;

import java.util.Date;

public class FindProductOutputDTO {
  
        private String name;
        private int price;
        private int maMh;
        private int quantity;
        private String dvt;
        private String category;
        private String nhacc;
        private Date NSX;
        private Date HSD;
       
        public FindProductOutputDTO(int maMh,String name, int price,  int quantity, String dvt, String category, String nhacc, Date NSX, Date HSD) {
            this.name = name;
            this.price = price;
            this.maMh = maMh;
            this.quantity = quantity;
            this.dvt = dvt;
            this.category = category;
            this.nhacc = nhacc;
            this.NSX = NSX;
            this.HSD = HSD;
        }
    
        public String getName() {
            return name;
        }
    
        public int getPrice() {
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
        public String getNhacc() {
            return nhacc;
        }
        public Date getNSX() {
            return NSX;
        }
        public Date getHSD() {
            return HSD;
        }
      
    }
    

