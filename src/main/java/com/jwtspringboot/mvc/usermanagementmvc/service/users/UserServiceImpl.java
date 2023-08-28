package com.jwtspringboot.mvc.usermanagementmvc.service.users;

import com.jwtspringboot.mvc.usermanagementmvc.controller.exceptions.authentication.RoleNotFoundException;
import com.jwtspringboot.mvc.usermanagementmvc.model.authentication.AuthDTO;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.RoleEntity;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserEntity;
import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserRole;
import com.jwtspringboot.mvc.usermanagementmvc.repository.IRoleRepository;
import com.jwtspringboot.mvc.usermanagementmvc.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.Set;

@RequiredArgsConstructor
@Service
public class UserServiceImpl implements IUserService{

    private final IUserRepository iUserRepository;
    private final IRoleRepository iRoleRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public UserEntity save(AuthDTO authDTO) {
        Optional<RoleEntity> roleOptional = iRoleRepository.getByName(UserRole.USER);
        RoleEntity userRole = roleOptional.orElseThrow(() -> new RoleNotFoundException("Role not found: " + UserRole.USER));
        UserEntity userEntity = new UserEntity(null, authDTO.getUsername(), passwordEncoder.encode(authDTO.getPassword()), Set.of(userRole));
        return iUserRepository.save(userEntity);
    }

    @Override
    public List<UserEntity> getAll() {
        return iUserRepository.findAll();
    }

    @Override
    public void initializeUsers() {
        iUserRepository.save(new UserEntity(null, "ADMIN",passwordEncoder.encode("2210"),Set.of(new RoleEntity(UserRole.ADMIN))));
        iUserRepository.save(new UserEntity(null, "GUEST",passwordEncoder.encode("1234"),Set.of(new RoleEntity(UserRole.GUEST))));
    }
}
