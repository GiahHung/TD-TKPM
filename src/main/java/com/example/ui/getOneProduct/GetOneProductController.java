package com.example.ui.getOneProduct;

import com.example.usecase.getAllCode.GetAllCodeInputBoundary;
import com.example.usecase.getOneProduct.GetOneProductInputBoundary;

public class GetOneProductController {
GetOneProductInputBoundary input = null;

public GetOneProductController(GetOneProductInputBoundary input){
this.input = input;
}

public void execute(int mamh){
input.execute(mamh);
}
}
