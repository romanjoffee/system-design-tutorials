package com.system_design.tutorials.service;

import com.system_design.tutorials.domain.User;
import com.system_design.tutorials.dto.LoginCredentials;
import com.system_design.tutorials.dto.LoginResponse;
import com.system_design.tutorials.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.BadCredentialsException;

import java.util.UUID;

@org.springframework.stereotype.Service
public class LoginService {

    private final UserRepository userRepository;

    @Autowired
    public LoginService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public LoginResponse authenticate(LoginCredentials loginCredentials) {
        User user = userRepository.findOneByUsername(loginCredentials.getUsername()).get();
        if (loginCredentials.getPassword().equals(user.getPassword())) {
            return new LoginResponse("Success", generateAccessToken());
        }
        throw new BadCredentialsException("Unauthorized");
    }

    private String generateAccessToken() {
        // Proper logic to retrieve access token - can use Oauth2
        return UUID.randomUUID().toString();
    }
}
