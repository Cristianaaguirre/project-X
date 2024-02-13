package com.app.userservice.models.dto;

import lombok.Builder;
import lombok.Data;

@Builder
@Data
public class RegisterDTO {
    private String username;
    private String password;
    private String email;
}
