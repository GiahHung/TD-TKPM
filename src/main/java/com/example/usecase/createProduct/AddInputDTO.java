package com.example.usecase.createProduct;
import java.util.*;;

public class AddInputDTO {
    private int maMh;
    private String name;
    private int price; 
    private String category; 
    private int quantity; 
    private String dvt;
    private Date nSX; 
    private Date hSD; 
    private String nhaCungCap;
    private int baoHanh;
    private int congSuat; 
    private String nhaSanXuat; 
    private Date ngayNhapKho;
    public AddInputDTO(int maMh, String name, int price, String category, int quantity, String dvt) {
        this.maMh = maMh;
        this.name = name;
        this.price = price;
        this.category = category;
        this.quantity = quantity;
        this.dvt = dvt;
    }
    public AddInputDTO(int maMh, String name, int price, String category, int quantity, String dvt, Date nSX,
            Date hSD, String nhaCungCap) {
        this(maMh, name, price, category, quantity, dvt);
        this.nSX = nSX;
        this.hSD = hSD;
        this.nhaCungCap = nhaCungCap;
    }
    public AddInputDTO(int maMh, String name, int price, String category, int quantity, String dvt,String nhaSanXuat, Date ngayNhapKho) {
       this(maMh, name, price, category, quantity, dvt);
        this.nhaSanXuat = nhaSanXuat;
        this.ngayNhapKho = ngayNhapKho;
    }
    public AddInputDTO(int maMh, String name, int price, String category, int quantity, String dvt, int baoHanh,
    int congSuat) {
       this(maMh, name, price, category, quantity, dvt);
        this.baoHanh = baoHanh;
        this.congSuat = congSuat;
    }
    public int getMaMh() {
        return maMh;
    }
    public String getName() {
        return name;
    }
    public int getPrice() {
        return price;
    }
    public String getCategory() {
        return category;
    }
    public int getQuantity() {
        return quantity;
    }
    public String getDvt() {
        return dvt;
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
