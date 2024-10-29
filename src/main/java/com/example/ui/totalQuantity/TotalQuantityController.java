package com.example.ui.totalQuantity;

import com.example.usecase.totalQuantity.TotalQuantityInputBoundary;

public class TotalQuantityController {
  private TotalQuantityInputBoundary totalQuantityInputBoundary = null;
  public TotalQuantityController(TotalQuantityInputBoundary totalQuantityInputBoundary){
    this.totalQuantityInputBoundary = totalQuantityInputBoundary;
  }
  public void execute(){
    totalQuantityInputBoundary.execute();
  }
}
