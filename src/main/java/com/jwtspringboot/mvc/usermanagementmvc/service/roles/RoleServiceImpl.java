package com.jwtspringboot.mvc.usermanagementmvc.service.roles;

import com.jwtspringboot.mvc.usermanagementmvc.model.user.RoleEntity;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserRole;
import com.jwtspringboot.mvc.usermanagementmvc.repository.IRoleRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class RoleServiceImpl implements IRoleService {
    private final IRoleRepository iRoleRepository;

    public void initializeRoles() {
        if (!iRoleRepository.getByName(UserRole.USER).isPresent()) {
            RoleEntity userRole = new RoleEntity(UserRole.USER);
            iRoleRepository.save(userRole);
        }
        if (!iRoleRepository.getByName(UserRole.ADMIN).isPresent()) {
            RoleEntity adminRole = new RoleEntity(UserRole.ADMIN);
            iRoleRepository.save(adminRole);
        }
        if (!iRoleRepository.getByName(UserRole.GUEST).isPresent()) {
            RoleEntity guestRole = new RoleEntity(UserRole.GUEST);
            iRoleRepository.save(guestRole);
        }
    }
}
