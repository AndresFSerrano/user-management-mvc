package com.jwtspringboot.mvc.usermanagementmvc.config;

import com.jwtspringboot.mvc.usermanagementmvc.service.users.IUserService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;

@Configuration
public class UserInitializationConfig {

    private final IUserService iUserService;


    public UserInitializationConfig(IUserService iUserService) {
        this.iUserService = iUserService;
    }

    @PostConstruct
    public void init(){
        iUserService.initializeUsers();
    }
}
