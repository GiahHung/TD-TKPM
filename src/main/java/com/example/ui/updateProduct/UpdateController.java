package com.example.ui.updateProduct;

import com.example.usecase.updateProduct.UpdateInputBoundary;
import com.example.usecase.updateProduct.UpdateInputDTO;

public class UpdateController {
      UpdateInputBoundary updateInputBoundary = null;
      public UpdateController(UpdateInputBoundary updateInputBoundary){
          this.updateInputBoundary = updateInputBoundary;
      }
      public void execute(UpdateInputDTO inputDTO){
          updateInputBoundary.execute(inputDTO);
      }
}
