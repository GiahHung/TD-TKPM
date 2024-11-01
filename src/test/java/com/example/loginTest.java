package com.example;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import com.example.database.LoginDAO;
import com.example.ui.login.LoginPresenter;
import com.example.usecase.login.LoginInputDTO;
import com.example.usecase.login.LoginUsecase;
import com.example.usecase.login.ResponeData;

public class loginTest {
@Test
public void login() throws Exception{
    LoginDAO data = new LoginDAO();
    LoginPresenter presenter = new LoginPresenter();
    LoginUsecase usecase = new LoginUsecase(data, presenter);
    LoginInputDTO DTO = new LoginInputDTO("hung", "123");
    usecase.execute(DTO);
    ResponeData res = presenter.getRes();
    assertEquals("Đăng nhập thành công", res.getMessageSuccess());
}
}

