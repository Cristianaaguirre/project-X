package com.app.userservice.service;

import com.app.userservice.jwt.Jwt;
import com.app.userservice.controller.dto.AuthRequest;
import com.app.userservice.controller.dto.RegisterRequest;

public interface IUserService {

    void registerUser(RegisterRequest register);
    Jwt loginUser(AuthRequest authRequest);
    Jwt validate(String token);
}
