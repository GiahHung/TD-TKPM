package com.example.usecase.register;

import java.security.MessageDigest;
import java.util.Base64;

import com.example.entity.User;

public class ResgisterUsecase implements ResgisterInputBoundary{
    ResgisterDataBoundary data = null;
    ResgisterOutputBoundary output = null;
    public ResgisterUsecase(ResgisterDataBoundary data, ResgisterOutputBoundary output){
        this.data = data;
        this.output = output;
    }

    @Override
    public void execute(ResgisterInputDTO resgisterInputDTO) throws Exception{
    User user = new User(resgisterInputDTO.getUserName(), hashText(resgisterInputDTO.getPassword()));
    Boolean checkUserName = data.checkUserName(user);
    if(checkUserName){
        ResponeData res = new ResponeData();
        res.messageFail = "Username đã tồn tại";
        output.presenter(res);
    }else{
        data.register(user);
        ResponeData res = new ResponeData();
        res.messageSuccess = "Đăng ký thành công";
        output.presenter(res);  
    }
    
}
   public String hashText(String password) throws Exception {
    String plainText = password;
    MessageDigest digest = MessageDigest.getInstance("SHA-256");
    byte[] hashedBytes = digest.digest(plainText.getBytes());
    return Base64.getEncoder().encodeToString(hashedBytes);
    }
}