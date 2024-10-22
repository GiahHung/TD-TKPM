package com.example.ui.totalQuantity;

import com.example.usecase.totalQuantity.TotalQuantityOutputBoundary;

public class TotalQuantityPresenter implements TotalQuantityOutputBoundary{
    public int totalQuantityFood = 0;
    public int totalQuantityCeramic = 0;
    public int totalQuantityElectronic = 0;
    @Override
    public void presenterFoodQuantity(int totalQuantity) {
        this.totalQuantityFood = totalQuantity;
        
    }

    @Override
    public void presenterCeramicQuantity(int totalQuantity) {
        this.totalQuantityCeramic = totalQuantity;
    }

    @Override
    public void presenterElectronicQuantity(int totalQuantity) {
        this.totalQuantityElectronic = totalQuantity;
    }

}
