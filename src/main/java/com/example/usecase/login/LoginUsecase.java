package com.example.usecase.login;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

import com.example.entity.User;

public class LoginUsecase implements LoginInputBoundary{
    LoginDataBoundary data = null;
    LoginOutputBoundary output = null;
    public LoginUsecase(LoginDataBoundary data, LoginOutputBoundary output) {
        this.data = data;
        this.output = output;
    }

    @Override
    public void execute(LoginInputDTO loginInputDTO) throws Exception {
        User user = new User(loginInputDTO.getUserName(), hashPassword(loginInputDTO.getPassword()));
        Boolean checkUser = data.getUser(user);
        if(checkUser){
            ResponeData res = new ResponeData();
            res.messageSuccess = "Đăng nhập thành công";
            output.presenter(res);
        }else{
            ResponeData res= new ResponeData();
            res.messageFail = "Tài khoản hoặc mật khẩu không đúng";
            output.presenter(res);
        }
    }

     public String hashPassword(String password) throws NoSuchAlgorithmException {
	        MessageDigest digest = MessageDigest.getInstance("SHA-256");
	        byte[] hashedBytes = digest.digest(password.getBytes());

	        // Convert the hashed bytes into a readable string using Base64 encoding
	        return Base64.getEncoder().encodeToString(hashedBytes);
	    }

}
