package com.example.ui.addProduct;

import com.example.usecase.createProduct.AddOutPutBoundary;
import com.example.usecase.createProduct.AddOutputDTO;
import com.example.usecase.createProduct.ResponeData;

public class AddPresenter implements AddOutPutBoundary{
    AddOutputDTO addOutputDTO = null;
    ResponeData res = null;
    @Override
    public void present(AddOutputDTO addOutputDTO) {
       this.addOutputDTO = addOutputDTO;
    }
    public AddOutputDTO geOutputDTO(){
        return addOutputDTO;
    }
    @Override
    public void presentMessage(ResponeData res) {
        this.res = res;
    }
    public ResponeData getResponeData(){
        return res;
    }


}
