package com.app.userservice.controller.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String email;
}
