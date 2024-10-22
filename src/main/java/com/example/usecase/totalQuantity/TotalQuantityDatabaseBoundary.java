package com.example.usecase.totalQuantity;

import java.util.List;

import com.example.entity.Product;

public interface TotalQuantityDatabaseBoundary {
List<Product> getFoodQuantityList();
List<Product> getCeramicQuantityList();
List<Product> getElectronicQuantityList();
}
