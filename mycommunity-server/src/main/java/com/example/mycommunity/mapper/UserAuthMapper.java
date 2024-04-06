package com.example.mycommunity.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import com.example.mycommunity.model.UserAuth;

@Mapper
public interface UserAuthMapper {
    public List<UserAuth> findUserAuthByUserId(Long userId);
    public void addUserAuth(UserAuth userAuth);
    public void deleteUserAuth(Long userId, Long appId);
}