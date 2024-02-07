package com.app.userservice.service;

import com.app.userservice.models.dto.RegisterDTO;
import com.app.userservice.models.repository.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements IUserService{

    private final UserRepository repository;

    @Override
    public void registerUser(RegisterDTO register) {

    }


}
