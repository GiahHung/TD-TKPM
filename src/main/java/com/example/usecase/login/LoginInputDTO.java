package com.example.usecase.login;

public class LoginInputDTO {
String userName;
String password;

public LoginInputDTO(String userName, String password) {
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
