package com.example.mycommunity.controller;

import org.springframework.web.bind.annotation.PostMapping;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import com.example.mycommunity.model.Application;
import com.example.mycommunity.model.UserAuth;
import com.example.mycommunity.service.ApplicationService;
import com.example.mycommunity.service.UserAuthService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class UserAuthController {

    private final UserAuthService userAuthService;
    private final ApplicationService applicationService;

    @GetMapping("/userauth/{userId}")
    public List<Application> getUserAuth(@PathVariable Long userId){
        List<UserAuth> userAuths = userAuthService.findUserAuthByUserId(userId);
        List<Application> apps = new ArrayList<Application>();
        Iterator<UserAuth> iterator = userAuths.iterator();
        while (iterator.hasNext()) {
            UserAuth userAuth = iterator.next();
            Application app = applicationService.findById(userAuth.getAppId());
            apps.add(app);
        }
        return apps;
    }

    @PostMapping("/userauth")
    public void addUserAuth(@RequestBody UserAuth userAuth){
        userAuthService.addUserAuth(userAuth);
    }

    @DeleteMapping("/userauth")
    public void deleteUserAuth(@RequestParam Long userId, @RequestParam Long appId){
        userAuthService.deleteUserAuth(userId, appId);
    }
}
