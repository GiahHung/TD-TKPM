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
       
        List<Product> quantityList = data.getQuantityList(inputDTO.getCategories());
        
        int totalQuantityFood = 0;
        int totalQuantityCeramic = 0;
        int totalQuantityElectronic = 0;
    
  
        for (Product product : quantityList) {
          String category = product.getCategory().toLowerCase();
  
          if (inputDTO.getCategories().contains(category)) {
              switch (category) {
                  case "food":
                      totalQuantityFood += product.totalQuantity();
                      break;
                  case "ceramic":
                      totalQuantityCeramic += product.totalQuantity();
                      break;
                  case "electronic":
                      totalQuantityElectronic += product.totalQuantity();
                      break;
              }
          }
        }
        TotalQuantityOutputDTO outputDTO = new TotalQuantityOutputDTO(totalQuantityFood, totalQuantityCeramic, totalQuantityElectronic);

        output.presentTotalQuantity(outputDTO);
      }
  
}
