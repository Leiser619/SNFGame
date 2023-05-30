package org.example.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import org.example.model.Role;

@AllArgsConstructor
@Getter @Setter
public class RegisterRequest {

    private final String username;
    private final String password;
    private final Role role;
}
