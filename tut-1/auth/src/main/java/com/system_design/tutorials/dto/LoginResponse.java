package com.system_design.tutorials.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class LoginResponse {

    private String status;

    private String accessToken;
}
