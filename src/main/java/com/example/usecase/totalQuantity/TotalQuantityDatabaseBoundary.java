package com.example.usecase.totalQuantity;

import java.util.List;
import java.util.Set;

import com.example.entity.Product;

public interface TotalQuantityDatabaseBoundary {
    List<Product> getQuantityList(Set<String> categories);
// List<Product> getFoodQuantityList();
// List<Product> getCeramicQuantityList();
// List<Product> getElectronicQuantityList();
}
