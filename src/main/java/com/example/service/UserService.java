package com.example.service;


import com.example.dto.UserDTO;
import com.example.model.Notice;
import com.example.model.User;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.Optional;

public interface UserService extends org.springframework.security.core.userdetails.UserDetailsService {

    User update(User user, UserDTO params);
    Optional<User> findUser(Long id);
    User createUser(UserDTO userDTO);

}