package com.system_design.tutorials.controller;

import com.system_design.tutorials.dto.LoginCredentials;
import com.system_design.tutorials.dto.LoginResponse;
import com.system_design.tutorials.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.web.bind.annotation.PostMapping;

@org.springframework.web.bind.annotation.RestController
public class LoginController {

    private final LoginService loginService;

    @Autowired
    LoginController(LoginService loginService) {
        this.loginService = loginService;
    }

    @PostMapping(value = "/login", consumes = "application/x-www-form-urlencoded")
    public ResponseEntity<LoginResponse> login(LoginCredentials loginCredentials) {
        try {
            LoginResponse loginResponse = loginService.authenticate(loginCredentials);
            return org.springframework.http.ResponseEntity.ok(loginResponse);
        } catch (BadCredentialsException ex) {
            //Handle login exception
        }
        return null;
    }
}
