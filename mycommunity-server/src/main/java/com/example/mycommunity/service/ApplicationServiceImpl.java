package com.example.mycommunity.service;

import java.util.List;

import org.springframework.stereotype.Service;

import com.example.mycommunity.mapper.ApplicationMapper;
import com.example.mycommunity.model.Application;
import lombok.RequiredArgsConstructor;

@RequiredArgsConstructor
@Service
public class ApplicationServiceImpl implements ApplicationService{

    private final ApplicationMapper applicationMapper;

    @Override
    public Application findById(Long appId) {
        return applicationMapper.findById(appId);
    }

    @Override
    public void addApp(Application app) {
        applicationMapper.addApp(app);
    }

    @Override
    public void updateApp(Application app) {
        applicationMapper.updateApp(app);
    }

    @Override
    public List<Application> findAll() {
        return applicationMapper.findAll();
    }

    @Override
    public void deleteById(Long id) {
        applicationMapper.deleteById(id);
    }
    
}
