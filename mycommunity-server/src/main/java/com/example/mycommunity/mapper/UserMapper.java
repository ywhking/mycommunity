package com.example.mycommunity.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.mycommunity.model.User;

@Mapper
public interface UserMapper {
    public void addUser(User user);
    public User findById(Long userId);
    public void deleteUser(Long userId);
    
}
