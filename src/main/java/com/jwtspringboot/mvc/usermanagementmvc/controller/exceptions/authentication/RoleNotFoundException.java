package com.jwtspringboot.mvc.usermanagementmvc.controller.exceptions.authentication;

public class RoleNotFoundException extends RuntimeException{

    public RoleNotFoundException(String message){
        super(message);
    }
}
