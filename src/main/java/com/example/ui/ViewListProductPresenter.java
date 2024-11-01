package com.example.ui;

import java.util.List;
import com.example.usecase.OutputBoundary;
import com.example.usecase.ViewProductDTO;



public class ViewListProductPresenter implements OutputBoundary {
    List<ViewProductDTO> viewProductDTOs = null;
    private CRUDForm crudForm = null;
   
    @Override
    public void present(List<ViewProductDTO> viewProductDTOs) {
     this.viewProductDTOs = viewProductDTOs;
   // crudForm = new CRUDForm();
   // crudForm.CRUD(viewProductDTOs);
    
    }

    public List<ViewProductDTO> getViewProductDTOs() {
        return this.viewProductDTOs;
    }

}
