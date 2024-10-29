package com.example.usecase.createProduct;

public interface AddOutPutBoundary {
void present(AddOutputDTO addOutputDTO);

void presentError(ResponeData res);
}
