package com.example.mycommunity.service;

import java.util.List;
import com.example.mycommunity.model.UserAuth;;

public interface UserAuthService{
    public List<UserAuth> findUserAuthByUserId(Long userId);
    public void addUserAuth(UserAuth userAuth);
    public void deleteUserAuth(Long userId, Long appId);
}