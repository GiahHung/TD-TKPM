package com.example.ui.deleteProduct;

import com.example.usecase.deleteProduct.DeleteInputBoundary;
import com.example.usecase.deleteProduct.DeleteInputDTO;

public class DeleteProductController {
   private DeleteInputBoundary deleteInputBoundary= null;
   public DeleteProductController(DeleteInputBoundary deleteInputBoundary){
       this.deleteInputBoundary = deleteInputBoundary;
   }
   public void execute(DeleteInputDTO deleteInputDTO){
       deleteInputBoundary.execute(deleteInputDTO);
   }
}
