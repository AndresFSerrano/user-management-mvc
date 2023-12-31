package com.jwtspringboot.mvc.usermanagementmvc.service.authentication;

import com.jwtspringboot.mvc.usermanagementmvc.model.user.UserEntity;
import com.jwtspringboot.mvc.usermanagementmvc.repository.IUserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.stream.Collectors;

@RequiredArgsConstructor
@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final IUserRepository iUserRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserEntity userEntity = iUserRepository.getByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("El usuario "+ username +" no existe."));

        Collection<? extends GrantedAuthority> authorities = userEntity.getRoles().stream()
                .map(role ->
                        new SimpleGrantedAuthority("ROLE_".concat(role.getName().name()))).collect(Collectors.toSet());

        return new User(userEntity.getUsername(),
                userEntity.getPassword(),
                true,
                true,
                true,
                true, authorities);
    }
}
