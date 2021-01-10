package com.system_design.tutorials.dto;

import lombok.AllArgsConstructor;

@lombok.Data
public class LoginResponse {
    private String status;
    private String accessToken;
}
