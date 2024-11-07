package com.example.usecase.deleteProduct;

import com.example.entity.Product;

public interface DeleteDatabaseBoundary {
void delete(int mamh);
boolean checkProduct(int mamh);
}
