package com.example.ui.findProduct;

import com.example.usecase.findProduct.FindProductInputBoundary;

public class FindProductController {
      FindProductInputBoundary findProductInputBoundary = null;
      public FindProductController(FindProductInputBoundary findProductInputBoundary){
          this.findProductInputBoundary = findProductInputBoundary;
      }
      public void execute(){
          findProductInputBoundary.execute();
      }
}
