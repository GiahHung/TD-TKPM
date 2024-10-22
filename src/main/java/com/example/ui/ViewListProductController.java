package com.example.ui;

import com.example.usecase.InputBoundary;

public class ViewListProductController {

	InputBoundary inputBoundary = null;

	public ViewListProductController(InputBoundary inputBoundary){
		this.inputBoundary = inputBoundary;
	}
	
	public void execute(){
		inputBoundary.execute();
	}
		
}


