package com.example.ui.addProduct;

import com.example.usecase.createProduct.AddInputBoundary;
import com.example.usecase.createProduct.AddInputDTO;

public class AddController {
    AddInputBoundary addInputBoundary = null;
    public AddController(AddInputBoundary addInputBoundary){
        this.addInputBoundary = addInputBoundary;
    }
    public void execute(AddInputDTO addInputDTO){
        addInputBoundary.execute(addInputDTO);
    }

}
