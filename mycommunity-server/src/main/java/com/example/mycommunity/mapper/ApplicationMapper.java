package com.example.mycommunity.mapper;

import java.util.List;
import org.apache.ibatis.annotations.Mapper;
import com.example.mycommunity.model.Application;

@Mapper
public interface ApplicationMapper {
    public void addApp(Application app);
    public void updateApp(Application app);
    public List<Application> findAll();
    public Application findById(Long id);
    public void deleteById(Long id);
}
