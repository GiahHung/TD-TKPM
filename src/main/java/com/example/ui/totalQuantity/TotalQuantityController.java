package com.example.ui.totalQuantity;

import com.example.usecase.totalQuantity.TotalQuantityInputBoundary;
import com.example.usecase.totalQuantity.TotalQuantityInputDTO;

public class TotalQuantityController {
  private TotalQuantityInputBoundary totalQuantityInputBoundary = null;
  public TotalQuantityController(TotalQuantityInputBoundary totalQuantityInputBoundary){
    this.totalQuantityInputBoundary = totalQuantityInputBoundary;
  }
  public void execute(TotalQuantityInputDTO DTO){
    totalQuantityInputBoundary.execute(DTO);
  }
}
