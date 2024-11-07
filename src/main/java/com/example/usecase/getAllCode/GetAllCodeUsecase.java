package com.example.usecase.getAllCode;

import java.util.List;

import com.example.entity.AllCode;

public class GetAllCodeUsecase implements GetAllCodeInputBoundary{
    GetAllCodeDataBoundary data = null;
    GetAllCodeOutputBoundary outputBoundary = null;
    
    public GetAllCodeUsecase(GetAllCodeDataBoundary data, GetAllCodeOutputBoundary output){
        this.data = data;
        this.outputBoundary = output;
    }

    @Override
    public void execute(String type) {
        List<AllCode> allCode = data.getAllCodes(type);
        
        if ("category".equals(type)) {
            outputBoundary.presentCategory(allCode);
        } else if ("dvt".equals(type)) {
            outputBoundary.presentDVT(allCode);
        }
    }

}
