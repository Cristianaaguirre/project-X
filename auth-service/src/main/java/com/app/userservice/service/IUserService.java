package com.app.userservice.service;

import com.app.userservice.models.dto.RegisterDTO;

public interface IUserService {

    void registerUser(RegisterDTO register);
}
