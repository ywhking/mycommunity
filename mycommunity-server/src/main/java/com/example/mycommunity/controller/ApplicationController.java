package com.example.mycommunity.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.example.mycommunity.model.Application;
import com.example.mycommunity.service.ApplicationService;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@RestController
public class ApplicationController {

    private final ApplicationService appService;

    @PostMapping("/app")
    public void addApp(@RequestBody Application app){
        appService.addApp(app);
    }

    @PutMapping("/app")
    public void updateApp(@RequestBody Application app){
        appService.updateApp(app);

    }

    @GetMapping("/app/{id}")
    public List<Application> getApp(@PathVariable Long id){
        if(id != null){
            Application app = appService.findById(id);
            List<Application> apps = new ArrayList<Application>();
            apps.add(app);
            return apps;
        }else{
            List<Application> apps = appService.findAll();
            return apps;
        }
    }

    @DeleteMapping("/app/{id}")
    public void deleteApp(@PathVariable Long id){
        appService.deleteById(id);
    }
}
