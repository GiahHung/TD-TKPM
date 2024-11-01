package com.example.usecase;

import java.util.Date;

public class ViewProductDTO {
    
    private String name;
    private int price;
    private int maMh;
    private int quantity;
    private String dvt;
    private String category;
    private Date nSX; 
    private Date hSD; 
    private String nhaCungCap;
    private int baoHanh;
    private int congSuat; 
    private String nhaSanXuat; 
    private Date ngayNhapKho;
   
    public ViewProductDTO(String name, int price, int maMh, int quantity, String dvt, String category, Date nSX,
    Date hSD, String nhaCungCap,String nhaSanXuat, Date ngayNhapKho, int baoHanh,
    int congSuat) {
        this.name = name;
        this.price = price;
        this.maMh = maMh;
        this.quantity = quantity;
        this.dvt = dvt;
        this.category = category;
        this.nSX = nSX;
        this.hSD = hSD;
        this.nhaCungCap = nhaCungCap;
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
        this.baoHanh = baoHanh;
        this.congSuat = congSuat;
       
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

    public Date getnSX() {
        return nSX;
    }

    public Date gethSD() {
        return hSD;
    }

    public String getNhaCungCap() {
        return nhaCungCap;
    }

    public int getBaoHanh() {
        return baoHanh;
    }

    public int getCongSuat() {
        return congSuat;
    }

    public String getNhaSanXuat() {
        return nhaSanXuat;
    }

    public Date getNgayNhapKho() {
        return ngayNhapKho;
    }

   
    

   
    
}
