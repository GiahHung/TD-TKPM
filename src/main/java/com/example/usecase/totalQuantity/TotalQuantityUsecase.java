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
    public void execute() {
      TotalQuantityOutputDTO outputDTO =null;
        //food
      List<Product> foodQuantityList = data.getFoodQuantityList();
      int totalQuantityFood = 0;
      for (Product product : foodQuantityList) {
        totalQuantityFood += product.totalQuantity();
    }
      
     
       //ceramic
       List<Product> ceramicQuantityList = data.getCeramicQuantityList();
       int totalQuantityCeramic = 0;
       for (Product product : ceramicQuantityList) {
        totalQuantityCeramic += product.totalQuantity();
     }
       
       
        //electronic
      List<Product> electronicQuantityList = data.getElectronicQuantityList();
      int totalQuantityElectronic = 0;
      for (Product product : electronicQuantityList) {
        totalQuantityElectronic += product.totalQuantity();
    }
    outputDTO = new TotalQuantityOutputDTO(totalQuantityFood, totalQuantityCeramic, totalQuantityElectronic);
    output.presenterFoodQuantity(outputDTO);
    output.presenterCeramicQuantity(outputDTO);
    output.presenterElectronicQuantity(outputDTO);

    }
}
