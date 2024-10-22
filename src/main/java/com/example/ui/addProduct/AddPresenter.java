package com.example.ui.addProduct;

import com.example.usecase.createProduct.AddOutPutBoundary;
import com.example.usecase.createProduct.AddOutputDTO;

public class AddPresenter implements AddOutPutBoundary{
    AddOutputDTO addOutputDTO = null;
    @Override
    public void present(AddOutputDTO addOutputDTO) {
       this.addOutputDTO = addOutputDTO;
    }
    public AddOutputDTO geOutputDTO(){
        return addOutputDTO;
    }

}
