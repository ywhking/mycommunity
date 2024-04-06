package com.example.mycommunity.service;

import org.springframework.stereotype.Service;

import com.example.mycommunity.mapper.UserMapper;
import com.example.mycommunity.model.User;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements UserService{

    private final UserMapper userMapper;

    @Override
    public User findById(Long userId) {
        return userMapper.findById(userId);
    }

    @Override
    public void addUser(User user) {
        userMapper.addUser(user);
    }

    @Override
    public void deleteUser(Long userId) {
        userMapper.deleteUser(userId);
    }
    
}
