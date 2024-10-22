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
        //food
      List<Product> foodQuantityList = data.getFoodQuantityList();
      int totalQuantityFood = 0;
      for (Product product : foodQuantityList) {
        totalQuantityFood += product.getQuantity();
    }
      output.presenterFoodQuantity(totalQuantityFood);
       //ceramic
       List<Product> ceramicQuantityList = data.getCeramicQuantityList();
       int totalQuantityCeramic = 0;
       for (Product product : ceramicQuantityList) {
        totalQuantityCeramic += product.getQuantity();
     }
       output.presenterCeramicQuantity(totalQuantityCeramic);;
        //electronic
      List<Product> electronicQuantityList = data.getElectronicQuantityList();
      int totalQuantityElectronic = 0;
      for (Product product : electronicQuantityList) {
        totalQuantityElectronic += product.getQuantity();
    }
      output.presenterElectronicQuantity(totalQuantityElectronic);;

    }
}
