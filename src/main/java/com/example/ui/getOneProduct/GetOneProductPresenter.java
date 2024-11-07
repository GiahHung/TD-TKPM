package com.example.ui.getOneProduct;

import com.example.usecase.getOneProduct.GetOneProductOutputBoundary;
import com.example.usecase.getOneProduct.GetOneProductOutputDTO;

public class GetOneProductPresenter implements GetOneProductOutputBoundary{
    GetOneProductOutputDTO DTO = null;
    @Override
    public void present(GetOneProductOutputDTO dto) {
        this.DTO = dto;
    }

    public GetOneProductOutputDTO getOutputDTO(){
        return DTO;
    }

}
