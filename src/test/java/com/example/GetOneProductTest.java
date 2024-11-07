package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.database.GetOneProductDAO;
import com.example.ui.getOneProduct.GetOneProductPresenter;
import com.example.usecase.getOneProduct.GetOneProductOutputDTO;
import com.example.usecase.getOneProduct.GetOneProductUseCase;

public class GetOneProductTest {
@Test
public void testGetOneProduct() {
    GetOneProductPresenter presenter = new GetOneProductPresenter();
    GetOneProductDAO data = new GetOneProductDAO();
    GetOneProductUseCase usecase = new GetOneProductUseCase(data, presenter);
    usecase.execute(1);
    GetOneProductOutputDTO dto = presenter.getOutputDTO();
    assertEquals("tương ớt", dto.getName());
}
}
