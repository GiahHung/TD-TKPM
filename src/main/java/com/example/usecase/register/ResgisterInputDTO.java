package com.example.usecase.register;

public class ResgisterInputDTO {
    String userName;
    String password;
    
    public ResgisterInputDTO(String userName, String password) {
        this.userName = userName;
        this.password =  password;
    }
    
    public String getUserName() {
        return userName;
    }
    
    public String getPassword() {
        return password;
    }
}
