package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.database.FindProductDAO;
import com.example.ui.findProduct.FindProductPresenter;
import com.example.usecase.findProduct.FindProductOutputDTO;
import com.example.usecase.findProduct.FindProductUsecase;

public class FindProductTest {
       @Test
       public void findTYest(){
        FindProductDAO data = new FindProductDAO();
        FindProductPresenter presenter = new FindProductPresenter();
        FindProductUsecase usecase = new FindProductUsecase(presenter, data);
        usecase.execute();

        List<FindProductOutputDTO> list = presenter.getFindProductOutputDTOs();

        assertEquals(3, list.size());
    
      }
}
 