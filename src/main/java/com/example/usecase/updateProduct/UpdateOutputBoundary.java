package com.example.usecase.updateProduct;


public interface UpdateOutputBoundary {
void presenter(UpdateOutputDTO outputDTO);

void presentError(ResponeData res);
}
