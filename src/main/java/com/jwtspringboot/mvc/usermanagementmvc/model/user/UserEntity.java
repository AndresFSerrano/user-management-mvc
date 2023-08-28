package com.jwtspringboot.mvc.usermanagementmvc.model.user;

import jakarta.persistence.*;
import lombok.*;


import java.util.Set;

@Entity
@Table(name = "users")
@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String username;

    private String password;

    @ManyToMany(fetch = FetchType.EAGER,targetEntity = RoleEntity.class,cascade = CascadeType.PERSIST)
    @JoinTable(name = "user_roles",joinColumns = @JoinColumn(name = "user_id"), inverseJoinColumns = @JoinColumn(name = "role_id"))
    private Set<RoleEntity> roles;
}