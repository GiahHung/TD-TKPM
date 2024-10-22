package com.example.usecase.deleteProduct;

import com.example.entity.Product;

public interface DeleteDatabaseBoundary {
void delete(Product product);
boolean checkProduct(Product product);
}
