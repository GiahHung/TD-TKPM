package com.example.usecase.totalQuantity;

import java.util.List;
import com.example.entity.Product;

public class TotalQuantityUsecase implements TotalQuantityInputBoundary {
    private TotalQuantityOutputBoundary output;
    private TotalQuantityDatabaseBoundary data;

    public TotalQuantityUsecase(TotalQuantityOutputBoundary output, TotalQuantityDatabaseBoundary data) {
        this.output = output;
        this.data = data;
    }

    @Override
    public void execute(TotalQuantityInputDTO inputDTO) {
       
        int totalQuantity = data.getTotalQuantity(inputDTO.getCategories());
        TotalQuantityOutputDTO outputDTO = new TotalQuantityOutputDTO(totalQuantity);
        output.presentTotalQuantity(outputDTO);
      }
  
}
