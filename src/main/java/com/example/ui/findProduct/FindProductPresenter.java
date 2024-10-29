package com.example.ui.findProduct;

import java.util.List;

import com.example.usecase.findProduct.FindProductOutputBoundary;
import com.example.usecase.findProduct.FindProductOutputDTO;

public class FindProductPresenter implements FindProductOutputBoundary {
     List<FindProductOutputDTO> findProductOutputDTO = null;
    @Override
    public void presenter(List<FindProductOutputDTO> findProductOutputDTOs) {
        this.findProductOutputDTO = findProductOutputDTOs;
        FindProductForm findProductForm = new FindProductForm();
        findProductForm.ShowGUI(findProductOutputDTOs);
    }

    public List<FindProductOutputDTO> getFindProductOutputDTOs() {
        return this.findProductOutputDTO;
    }

}
