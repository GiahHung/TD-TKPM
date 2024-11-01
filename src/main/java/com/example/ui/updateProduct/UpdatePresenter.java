package com.example.ui.updateProduct;

import com.example.usecase.updateProduct.ResponeData;
import com.example.usecase.updateProduct.UpdateOutputBoundary;
import com.example.usecase.updateProduct.UpdateOutputDTO;

public class UpdatePresenter implements UpdateOutputBoundary {
    UpdateOutputDTO updateOutputDTO = null;
    ResponeData res = null;
    @Override
    public void presenter(UpdateOutputDTO outputDTO) {
        this.updateOutputDTO = outputDTO;
    }
    public UpdateOutputDTO getOutputDTO(){
        return updateOutputDTO;
    }

    @Override
    public void presentMessage(ResponeData res) {
        this.res = res;
    }
    public ResponeData getRes() {
        return res;
    }

}
