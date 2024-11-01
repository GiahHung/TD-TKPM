package com.example.ui.totalQuantity;

import com.example.usecase.totalQuantity.TotalQuantityOutputBoundary;
import com.example.usecase.totalQuantity.TotalQuantityOutputDTO;

public class TotalQuantityPresenter implements TotalQuantityOutputBoundary{
    
    private TotalQuantityOutputDTO outputDTO = null;
    @Override
    public void presentTotalQuantity(TotalQuantityOutputDTO outputDTO) {
        this.outputDTO = outputDTO;
       
        
    }

    public TotalQuantityOutputDTO getOutputDTO() {
        return outputDTO;
    }

}
