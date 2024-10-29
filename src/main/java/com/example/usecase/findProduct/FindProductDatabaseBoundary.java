package com.example.usecase.findProduct;

import java.util.List;

import com.example.entity.Product;

public interface FindProductDatabaseBoundary {
List<Product> getProductListExpired();
}
