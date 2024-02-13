package com.app.userservice.service;

import com.app.userservice.security.util.Jwt;
import com.app.userservice.models.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtProvider {

    String extractEmail(String token);
    Jwt generateToken(UserEntity user);
    void validate(String token);
}
