package com.example.ui.login;

import com.example.usecase.login.LoginInputBoundary;
import com.example.usecase.login.LoginInputDTO;

public class LoginController {
    LoginInputBoundary loginInputBoundary = null;
    public LoginController(LoginInputBoundary loginInputBoundary){
        this.loginInputBoundary = loginInputBoundary;
    }
    public void execute(LoginInputDTO loginInputDTO) throws Exception{
        loginInputBoundary.execute(loginInputDTO);
    }
}
