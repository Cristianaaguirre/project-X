package com.app.userservice.service;

import com.app.userservice.common.security.util.Jwt;
import com.app.userservice.models.dto.AuthRequest;
import com.app.userservice.models.dto.RegisterDTO;

public interface IUserService {

    void registerUser(RegisterDTO register);
    Jwt loginUser(AuthRequest authRequest);
}
