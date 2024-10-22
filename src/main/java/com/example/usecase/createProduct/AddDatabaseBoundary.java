package com.example.usecase.createProduct;

import com.example.entity.Product;

public interface AddDatabaseBoundary {
int addProduct(Product product);
Product findProduct(int newProductId);


}
