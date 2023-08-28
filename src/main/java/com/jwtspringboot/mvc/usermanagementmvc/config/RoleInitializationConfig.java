package com.jwtspringboot.mvc.usermanagementmvc.config;

import com.jwtspringboot.mvc.usermanagementmvc.service.roles.IRoleService;
import jakarta.annotation.PostConstruct;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RoleInitializationConfig {

    private final IRoleService iRoleService;

    public RoleInitializationConfig(IRoleService iRoleService) {
        this.iRoleService = iRoleService;
    }

    @PostConstruct
    public void init() {
        iRoleService.initializeRoles();
    }
}
