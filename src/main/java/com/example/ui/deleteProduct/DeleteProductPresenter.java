package com.example.ui.deleteProduct;


import com.example.usecase.deleteProduct.DeleteOutputBoundary;
import com.example.usecase.deleteProduct.DeleteOutputDTO;

public class DeleteProductPresenter implements DeleteOutputBoundary{
    
    DeleteOutputDTO deleteOutputDTO = null;
    @Override
    public void present(DeleteOutputDTO deleteOutputDTO) {
        this.deleteOutputDTO = deleteOutputDTO;
    }
    public DeleteOutputDTO getOutputDTO(){
        return deleteOutputDTO;
    }

}
