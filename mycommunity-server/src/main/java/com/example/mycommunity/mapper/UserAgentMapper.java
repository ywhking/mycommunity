package com.example.mycommunity.mapper;

import org.apache.ibatis.annotations.Mapper;

import com.example.mycommunity.model.UserAgent;

@Mapper
public interface UserAgentMapper {
    public void addUserAgent(UserAgent userAgent);
    public UserAgent getUserAgent(Long userId);
    public void deleteUserAgent(Long userId);
}
