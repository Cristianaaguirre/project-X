package com.app.userservice.jwt;

import com.app.userservice.models.UserEntity;

public interface JwtProvider {

    String extractEmail(String token);
    Jwt generateToken(UserEntity user);
    void validate(String token);
}
