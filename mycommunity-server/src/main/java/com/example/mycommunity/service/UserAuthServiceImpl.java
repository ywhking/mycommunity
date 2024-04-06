package com.example.mycommunity.service;

import com.example.mycommunity.model.UserAuth;
import lombok.RequiredArgsConstructor;
import java.util.List;
import org.springframework.stereotype.Service;
import com.example.mycommunity.mapper.UserAuthMapper;

@RequiredArgsConstructor
@Service
public class UserAuthServiceImpl implements UserAuthService{

    private final UserAuthMapper userAuthMapper;

    @Override
    public List<UserAuth> findUserAuthByUserId(Long userId){
        return userAuthMapper.findUserAuthByUserId(userId);
    }

    @Override
    public void addUserAuth(UserAuth userAuth){
        userAuthMapper.addUserAuth(userAuth);
    }

    @Override
    public void deleteUserAuth(Long userId, Long appId){
        userAuthMapper.deleteUserAuth(userId, appId);
    }

}