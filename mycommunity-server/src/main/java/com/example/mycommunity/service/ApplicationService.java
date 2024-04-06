package com.example.mycommunity.service;

import java.util.List;
import com.example.mycommunity.model.Application;

public interface ApplicationService {
    public Application findById(Long id);
    public void addApp(Application app);
    public void updateApp(Application app);
    public List<Application> findAll();
    public void deleteById(Long id);    
}
