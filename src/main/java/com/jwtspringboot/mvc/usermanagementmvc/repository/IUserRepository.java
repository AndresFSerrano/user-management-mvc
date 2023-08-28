package com.jwtspringboot.mvc.usermanagementmvc.repository;

import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IUserRepository extends JpaRepository<UserEntity,Long> {
    Optional<UserEntity> getByUsername(String username);

}
