package com.devsuperior.dscatalog.dto;

import com.devsuperior.dscatalog.entities.User;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.util.HashSet;
import java.util.Set;

@NoArgsConstructor
@Getter
@Setter
public class UserDTO {

    private Long id;
    private String firstName;
    private String lastName;
    private String email;

    Set<RoleDTO> roles = new HashSet<>();

    public UserDTO(Long id, String firstName, String email, String lastName) {
        this.id = id;
        this.firstName = firstName;
        this.lastName = lastName;
        this.email = email;
    }

    public UserDTO(User entity) {
        id = entity.getId();
        firstName = entity.getFirstName();
        lastName = entity.getLastName();
        email = entity.getEmail();

        entity.getRoles().forEach(role -> this.roles.add(new RoleDTO(role)));
    }
}
