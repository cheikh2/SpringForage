package com.sid.service;

import com.sid.entities.User;
import com.sid.web.dto.UserRegistrationDto;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.password.PasswordEncoder;

public interface UserService extends UserDetailsService {
    User save(UserRegistrationDto registrationDto);
}
