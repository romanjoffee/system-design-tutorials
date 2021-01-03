package com.system_design.tutorials.controller;

import com.system_design.tutorials.config.Configuration;
import com.system_design.tutorials.service.LoginService;
import org.springframework.beans.factory.annotation.Autowired;

@org.springframework.web.bind.annotation.RestController
public class LoginController {

    private final Configuration configuration;

    private final LoginService loginService;

    @Autowired
    LoginController(Configuration configuration,
                    LoginService loginService) {
        this.configuration = configuration;
        this.loginService = loginService;
    }
}
