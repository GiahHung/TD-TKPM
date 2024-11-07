package com.example;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.database.ResgisterDAO;
import com.example.ui.register.ResgisterPresenter;
import com.example.usecase.register.ResgisterInputDTO;
import com.example.usecase.register.ResgisterUsecase;
import com.example.usecase.register.ResponeData;

public class RegisterTest {
@Test
    public void testRegister() throws Exception {
        ResgisterDAO data = new ResgisterDAO();
        ResgisterPresenter presenter = new ResgisterPresenter();
        ResgisterUsecase usecase = new ResgisterUsecase(data,presenter );
        ResgisterInputDTO DTO = new ResgisterInputDTO("hung", "123","123");
        usecase.execute(DTO);
        ResponeData res = presenter.getRes();
        assertEquals("Username đã tồn tại", res.getMessageFail());
    }
}
