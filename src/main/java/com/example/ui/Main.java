package com.example.ui;

import com.example.database.*;
import com.example.usecase.UsecaseControl;


public class Main {
  public static void main(String[] args) {
    //View List Product
    ViewListProductPresenter presenter = new ViewListProductPresenter();
    ViewProductListDAO data = new ViewProductListDAO();
    UsecaseControl usecaseControl = new UsecaseControl(presenter, data);
    ViewListProductController viewListProductController = new ViewListProductController(usecaseControl);
    viewListProductController.execute();
  }
}
