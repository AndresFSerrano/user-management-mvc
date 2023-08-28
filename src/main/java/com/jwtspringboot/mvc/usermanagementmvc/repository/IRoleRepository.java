package com.jwtspringboot.mvc.usermanagementmvc.repository;

import com.jwtspringboot.mvc.usermanagementmvc.model.user.RoleEntity;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserRole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface IRoleRepository extends JpaRepository<RoleEntity,Long> {
    Optional<RoleEntity> getByName(UserRole name);


}
