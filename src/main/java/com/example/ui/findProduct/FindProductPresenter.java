package com.example.ui.findProduct;

import java.util.List;

import com.example.usecase.findProduct.FindProductOutputBoundary;
import com.example.usecase.findProduct.FindProductOutputDTO;
import com.example.usecase.findProduct.ResponeData;

public class FindProductPresenter implements FindProductOutputBoundary {
     List<FindProductOutputDTO> findProductOutputDTO = null;
     ResponeData res = null;

     FindProductForm findProductForm = null;
    @Override
    public void presenter(List<FindProductOutputDTO> findProductOutputDTOs) {
        this.findProductOutputDTO = findProductOutputDTOs;
        findProductForm = new FindProductForm(findProductOutputDTOs);
    
    }

    public List<FindProductOutputDTO> getFindProductOutputDTOs() {
        return this.findProductOutputDTO;
    }

    @Override
    public void presenterErr(ResponeData res) {
        this.res = res;
    }
    public ResponeData getRes(){
        return res;
    }

}
