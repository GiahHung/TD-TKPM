package com.example.usecase.register;

public class ResgisterInputDTO {
    String userName;
    String password;
    String confirmPassword;
    
    public ResgisterInputDTO(String userName, String password, String confirmPassword) {
        this.userName = userName;
        this.password =  password;
        this.confirmPassword = confirmPassword;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
    
    public String getConfirmPassword() {
        return confirmPassword;
    }
}
