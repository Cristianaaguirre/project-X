package com.app.userservice.controller.dto;

import lombok.Builder;
import lombok.Data;

public record RegisterRequest(
     String username,
     String password,
     String email
) {}
