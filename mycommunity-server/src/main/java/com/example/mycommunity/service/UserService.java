package com.example.mycommunity.service;

import com.example.mycommunity.model.User;

public interface UserService {

    public void addUser(User user);
    public User findById(Long userId);
    public void deleteUser(Long userId);
    
}
