package com.example.usecase;

import java.util.ArrayList;
import java.util.List;

import com.example.entity.Product;

public class ResponseData {
    private List<Product> productList;
    private String message = "ok";

    public ResponseData() {
        this.productList = new ArrayList<>();
    }
    
    public List<Product> getProductList() {
        return productList;
    }
    
    public void setProductList(List<Product> productList) {
        this.productList = productList;
    }

    public String getMessage() {
        return message;
    }

}
