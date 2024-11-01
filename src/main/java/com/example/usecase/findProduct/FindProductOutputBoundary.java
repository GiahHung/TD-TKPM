package com.example.usecase.findProduct;

import java.util.List;


public interface FindProductOutputBoundary {
void presenter(List<FindProductOutputDTO> findProductOutputDTOs);
void presenterErr(ResponeData res);
}
