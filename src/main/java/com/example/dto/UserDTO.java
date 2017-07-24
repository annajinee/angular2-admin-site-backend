package com.example.dto;


import com.example.model.Role;
import com.example.model.User;
import com.fasterxml.jackson.annotation.JsonProperty;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import javax.validation.constraints.Size;
import java.util.Collection;
import java.util.Collections;
import java.util.Optional;


public final class UserDTO {

    private static final String ROLE_USER = "ROLE_USER";

    private final String username;
    private final String password;
    private final String name;

    public UserDTO(@JsonProperty("username") String username,
                   @JsonProperty("password") String password,
                   @JsonProperty("name") String name) {
        this.username = username;
        this.password = password;
        this.name = name;
    }

    public Optional<String> getUsername() {
        return Optional.ofNullable(username);
    }

    public Optional<String> getEncodedPassword() {
        return Optional.ofNullable(password).map(p -> new BCryptPasswordEncoder().encode(p));
    }

    public Optional<String> getName() {
        return Optional.ofNullable(name);
    }

    public User toUser() {
        User user = new User();
        user.setUsername(username);
        user.setRole(new Role());
        user.setPassword(new BCryptPasswordEncoder().encode(password));
        user.setName(name);
        return user;
    }

    public UsernamePasswordAuthenticationToken toAuthenticationToken() {
        return new UsernamePasswordAuthenticationToken(username, password, getAuthorities());
    }

    public Collection<? extends GrantedAuthority> getAuthorities() {
        return Collections.singleton(() -> ROLE_USER);
    }

}