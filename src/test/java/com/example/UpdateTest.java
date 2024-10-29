package com.example;

import static org.junit.Assert.assertEquals;

import java.util.Calendar;
import java.util.Date;

import org.junit.Test;

import com.example.database.UpdateProductDAO;
import com.example.ui.updateProduct.UpdatePresenter;
import com.example.usecase.updateProduct.ResponeData;
import com.example.usecase.updateProduct.UpdateInputDTO;

import com.example.usecase.updateProduct.UpdateOutputDTO;
import com.example.usecase.updateProduct.UpdateUsecase;

public class UpdateTest {
    @Test
    public void testUpdateProduct() {
      UpdatePresenter presenter = new UpdatePresenter();
      UpdateProductDAO data = new UpdateProductDAO();
      UpdateUsecase updateUsecase = new UpdateUsecase(presenter, data);
  
      // Setting up NSX and HSD dates
      Calendar cal1 = Calendar.getInstance();
      cal1.set(2024, Calendar.JULY, 7);
      Date date1 = cal1.getTime();
  
      Calendar cal2 = Calendar.getInstance();
      cal2.set(2025, Calendar.DECEMBER, 8);
      Date date2 = cal2.getTime();
  
      // Creating input DTO for updating the product
      UpdateInputDTO updateInputDTO = new UpdateInputDTO(30, "cccc", 10000, "food", 20, "chai", date1, date2, "Chin-su");
  
      // Executing the update use case
      updateUsecase.execute(updateInputDTO);
  
      UpdateOutputDTO updateOutputDTO = presenter.getOutputDTO();
  
      
      assertEquals(updateInputDTO.getName(), updateOutputDTO.getName());
      assertEquals(updateInputDTO.getCategory(), updateOutputDTO.getCategory());
      assertEquals(updateInputDTO.getQuantity(), updateOutputDTO.getQuantity());
      assertEquals(updateInputDTO.getDvt(), updateOutputDTO.getDvt());
  
  
      // ResponeData res = presenter.getRes();
      // assertEquals("Thông tin không hợp lệ", res.getMessage());
    }
  }
  