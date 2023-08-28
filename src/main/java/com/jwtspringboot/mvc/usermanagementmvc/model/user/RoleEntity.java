package com.jwtspringboot.mvc.usermanagementmvc.model.user;

import jakarta.persistence.*;
import lombok.*;

import java.util.Set;

@Entity
@Table(name = "roles")
@Getter @Setter @AllArgsConstructor @NoArgsConstructor
public class RoleEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    private UserRole name;

    public RoleEntity(UserRole role) {
        this.name = role;
    }
}
