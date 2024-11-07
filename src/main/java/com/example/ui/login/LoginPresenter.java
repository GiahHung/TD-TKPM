package com.example.ui.login;

import com.example.usecase.login.LoginOutputBoundary;
import com.example.usecase.login.LoginOutputDTO;
import com.example.usecase.login.ResponeData;

public class LoginPresenter implements LoginOutputBoundary {
    ResponeData res = null;
    LoginOutputDTO dto = null;

    @Override
    public void presenter(ResponeData res) {
        this.res = res;
    }
    public ResponeData getRes(){
        return res;
    }
    @Override
    public void presenterRole(LoginOutputDTO dto) {
        this.dto = dto;
    }
    public LoginOutputDTO getDto(){
        return dto;
    }

}
