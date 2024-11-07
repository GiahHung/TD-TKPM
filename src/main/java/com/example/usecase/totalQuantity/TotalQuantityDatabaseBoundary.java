package com.example.usecase.totalQuantity;

import java.util.List;

import com.example.entity.Product;

public interface TotalQuantityDatabaseBoundary {
    List<Product> getQuantityList(String categories);

}
