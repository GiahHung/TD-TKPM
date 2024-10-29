package com.example.usecase.updateProduct;

import com.example.entity.Product;

public interface UpdateDatabaseBoundary {
int update(Product product);
boolean checkProduct(Product product);
Product findProduct(int mamh);
}
