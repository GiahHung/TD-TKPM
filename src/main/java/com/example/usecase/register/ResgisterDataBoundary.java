package com.example.usecase.register;

import com.example.entity.User;

public interface ResgisterDataBoundary {
void register(User user);
Boolean checkUserName(User user);
}
