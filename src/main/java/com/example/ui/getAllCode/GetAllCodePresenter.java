package com.example.ui.getAllCode;

import java.util.List;

import com.example.entity.AllCode;
import com.example.usecase.getAllCode.GetAllCodeOutputBoundary;

public class GetAllCodePresenter implements GetAllCodeOutputBoundary{
    List<AllCode> category = null;
    List<AllCode> dvt = null;
 
    public List<AllCode> getCategory() {
        return this.category;
    }
    public List<AllCode> getDVT() {
        return this.dvt;
    }
    @Override
    public void presentCategory(List<AllCode> category) {
        this.category = category;
    }
    @Override
    public void presentDVT(List<AllCode> dvt) {
        this.dvt = dvt;
    }

}
