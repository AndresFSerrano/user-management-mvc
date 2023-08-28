package com.jwtspringboot.mvc.usermanagementmvc.controller;

import org.springframework.security.access.annotation.Secured;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/tests")
public class TestRolesController {

    @GetMapping("/accessAdmin")
    @Secured("ROLE_ADMIN")
    public String accessAdmin() {
        return "Hola has accedido con el rol ADMIN";
    }

    @GetMapping("/accessUser")
    @Secured({"ROLE_USER","ROLE_ADMIN"})
    public String accessUser() {
        return "Hola has accedido con el rol USER";
    }

    @GetMapping("/accessGuest")
    @Secured({"ROLE_GUEST","ROLE_ADMIN","ROLE_USER"})
    public String accessGuest() {
        return "Hola has accedido con el rol GUEST";
    }
}
