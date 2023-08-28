package com.jwtspringboot.mvc.usermanagementmvc.controller.exceptions;

import com.jwtspringboot.mvc.usermanagementmvc.controller.exceptions.authentication.UserNotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ProblemDetail;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionController {
    @ExceptionHandler({UserNotFoundException.class})
    public ProblemDetail userNotFound(RuntimeException runtimeException){
         return ProblemDetail.forStatusAndDetail(HttpStatus.BAD_REQUEST,runtimeException.getMessage());
    }
}
