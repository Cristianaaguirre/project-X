package com.app.userservice.controller.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

public record AuthRequest(
     String email,
     String password
) {}
