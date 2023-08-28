package com.jwtspringboot.mvc.usermanagementmvc.controller;

import com.jwtspringboot.mvc.usermanagementmvc.model.authentication.AuthDTO;
import com.jwtspringboot.mvc.usermanagementmvc.service.users.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@RequestMapping("users")
public class UserController {

    private final IUserService iUserService;

    @GetMapping("/hello")
    public String hello(){
        return "Hello World not secured";
    }

    @GetMapping("helloSecured")
    public String helloSecured(){
        return "Hello World secured";
    }

    @PostMapping("/register")
    public ResponseEntity<?> registerUser(@RequestBody AuthDTO authDTO){
        return ResponseEntity.ok(iUserService.save(authDTO));
    }

    @GetMapping("/getAll")
    public ResponseEntity<?> getAll(){
        return ResponseEntity.ok(iUserService.getAll());
    }

}
