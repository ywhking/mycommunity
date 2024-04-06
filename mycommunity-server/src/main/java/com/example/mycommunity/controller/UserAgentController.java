package com.example.mycommunity.controller;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.mycommunity.model.UserAgent;
import com.example.mycommunity.service.UserAgentService;

import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserAgentController {
    
    private final UserAgentService userAgentService;

    @GetMapping("/agent/{userId}")
    public UserAgent getUserAgent(@PathVariable Long userId){
        return userAgentService.getUserAgent(userId);
    }


    @PostMapping("/agent/{userId}")
    public UserAgent addUserAgent(@PathVariable Long userId){
        return userAgentService.addUserAgent(userId);
    }

    @DeleteMapping("/agent/{userId}")
    public void deleteUserAgent(@PathVariable Long userId){
        userAgentService.deleteUserAgent(userId);
    }
}
