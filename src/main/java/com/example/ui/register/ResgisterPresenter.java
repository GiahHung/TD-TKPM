package com.example.ui.register;

import com.example.usecase.register.ResgisterOutputBoundary;
import com.example.usecase.register.ResponeData;

public class ResgisterPresenter implements ResgisterOutputBoundary{
    ResponeData res = null;

    @Override
    public void presenter(ResponeData res) {
       this.res = res;
    }
    public ResponeData getRes() {
        return res;
    }

}
