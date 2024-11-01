package com.example.ui.deleteProduct;

import java.util.List;

import com.example.ui.CRUDForm;
import com.example.usecase.OutputBoundary;
import com.example.usecase.ViewProductDTO;
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
