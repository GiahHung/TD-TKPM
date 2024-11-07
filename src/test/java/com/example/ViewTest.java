package com.example;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import java.util.List;

import org.junit.Test;

import com.example.database.ViewProductListDAO;
import com.example.ui.ViewListProductPresenter;
import com.example.usecase.InputBoundary;
import com.example.usecase.UsecaseControl;
import com.example.usecase.ViewProductDTO;


public class ViewTest 
{
     @Test
    public void getViewStudentListTestSucsess() {
        ViewProductListDAO database = new ViewProductListDAO();

        ViewListProductPresenter presenter = new ViewListProductPresenter();

        InputBoundary vSLUseCase = new UsecaseControl(presenter, database);

        vSLUseCase.execute();

        List<ViewProductDTO> viewProductDTOs =presenter.getViewProductDTOs();;
        
        //assertEquals(11, viewProductDTOs.size());
        for (ViewProductDTO product : presenter.getViewProductDTOs()) {
			String productName = product.getName().toLowerCase();
			String productId = String.valueOf(product.getMaMh());
            assertEquals("tương ớt", productName);
			
		}
      
        
    }
}
