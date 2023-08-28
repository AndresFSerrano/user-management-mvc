package com.jwtspringboot.mvc.usermanagementmvc.service.users;

import com.jwtspringboot.mvc.usermanagementmvc.model.authentication.AuthDTO;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserEntity;

import java.util.List;

public interface IUserService {

    UserEntity save(AuthDTO authDTO);

    List<UserEntity> getAll();

    void initializeUsers();
}
