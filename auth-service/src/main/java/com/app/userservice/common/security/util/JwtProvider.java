package com.app.userservice.common.security.util;

import com.app.userservice.models.entity.UserEntity;
import org.springframework.security.core.userdetails.UserDetails;

public interface JwtProvider {

    String extractEmail(String token);
    Boolean isTokenExpired(String token);
    Boolean validateEmail(String email, UserDetails userDetails);
    String generateToken(UserEntity user, Integer timeExpiration);
    Jwt createToken(UserEntity user);

}
