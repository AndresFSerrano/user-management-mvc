package com.jwtspringboot.mvc.usermanagementmvc.controller.exceptions.authentication;

public class UserNotFoundException extends RuntimeException{

    public UserNotFoundException(String message){
        super(message);
    }


}
