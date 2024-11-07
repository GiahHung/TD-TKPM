package com.example.usecase.register;

import java.security.MessageDigest;
import java.util.Base64;

import com.example.entity.User;
import com.example.usecase.ResponseData;

public class ResgisterUsecase implements ResgisterInputBoundary{
    ResgisterDataBoundary data = null;
    ResgisterOutputBoundary output = null;
    public ResgisterUsecase(ResgisterDataBoundary data, ResgisterOutputBoundary output){
        this.data = data;
        this.output = output;
    }

    @Override
    public void execute(ResgisterInputDTO resgisterInputDTO) throws Exception{
 
        if (!resgisterInputDTO.getConfirmPassword().equals(resgisterInputDTO.getPassword())) {
            ResponeData res = new ResponeData();
            res.messageConfirm = "Mật khẩu xác nhận không đúng";
            output.presenter(res);
            return;
        }

        User user = new User(resgisterInputDTO.getUserName(), hashText(resgisterInputDTO.getPassword()),null);
        
        boolean usernameExists = data.checkUserName(user);
        ResponeData res = new ResponeData();
        
        if (usernameExists) {
            res.messageFail = "Username đã tồn tại";
            output.presenter(res);
        } else {
            
            data.register(user);
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