package com.example.ui.totalQuantity;

import com.example.usecase.totalQuantity.TotalQuantityOutputBoundary;
import com.example.usecase.totalQuantity.TotalQuantityOutputDTO;

public class TotalQuantityPresenter implements TotalQuantityOutputBoundary{
    TotalQuantityForm totalQuantityForm = null;
    private TotalQuantityOutputDTO outputDTO = null;
    @Override
    public void presenterFoodQuantity(TotalQuantityOutputDTO outputDTO) {
        this.outputDTO = outputDTO;
        totalQuantityForm = new TotalQuantityForm(outputDTO.getFoodQuantity(), outputDTO.getCeramicQuantity(), outputDTO.getElectronicQuantity());
        
    }

    @Override
    public void presenterCeramicQuantity(TotalQuantityOutputDTO outputDTO) {
        this.outputDTO = outputDTO;
        totalQuantityForm = new TotalQuantityForm(outputDTO.getFoodQuantity(), outputDTO.getCeramicQuantity(), outputDTO.getElectronicQuantity());
        
    }

    @Override
    public void presenterElectronicQuantity(TotalQuantityOutputDTO outputDTO) {
        this.outputDTO = outputDTO;
        totalQuantityForm = new TotalQuantityForm(outputDTO.getFoodQuantity(), outputDTO.getCeramicQuantity(), outputDTO.getElectronicQuantity());
        totalQuantityForm.setVisible(true);
    }

    public TotalQuantityOutputDTO getOutputDTO() {
        return outputDTO;
    }

}
