package com.example;

import static org.junit.Assert.assertEquals;

import java.util.List;

import org.junit.Test;

import com.example.database.GetAllCodeDAO;
import com.example.database.ViewProductListDAO;
import com.example.entity.AllCode;
import com.example.ui.ViewListProductPresenter;
import com.example.ui.getAllCode.GetAllCodePresenter;
import com.example.usecase.InputBoundary;
import com.example.usecase.UsecaseControl;
import com.example.usecase.ViewProductDTO;
import com.example.usecase.getAllCode.GetAllCodeUsecase;

public class GetAllcodeTest {
 @Test
    public void getAllcode() {
       GetAllCodeDAO data = new GetAllCodeDAO();
       GetAllCodePresenter presenter = new GetAllCodePresenter();
       GetAllCodeUsecase usecase = new GetAllCodeUsecase(data,presenter);
       usecase.execute("category");
       List<AllCode> keymap = presenter.getCategory();
       assertEquals(3, keymap.size()); 
    }
}
