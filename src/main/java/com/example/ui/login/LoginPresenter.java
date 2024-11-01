package com.example.ui.login;

import com.example.usecase.login.LoginOutputBoundary;
import com.example.usecase.login.ResponeData;

public class LoginPresenter implements LoginOutputBoundary {
    ResponeData res = null;

    @Override
    public void presenter(ResponeData res) {
        this.res = res;
    }
    public ResponeData getRes(){
        return res;
    }

}
