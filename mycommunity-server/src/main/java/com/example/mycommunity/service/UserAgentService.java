package com.example.mycommunity.service;

import com.example.mycommunity.model.UserAgent;

public interface UserAgentService {
    public UserAgent addUserAgent(Long userId);
    public UserAgent getUserAgent(Long userId);
    public void deleteUserAgent(Long userId);

 }
