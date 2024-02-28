package com.app.userservice.models;

import com.app.userservice.controller.dto.RegisterRequest;

import java.util.UUID;

public class UserMapper {


    public static UserEntity dtoToEntity(RegisterRequest dto) {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .username(dto.username())
                .email(dto.email())
                .role(Role.USER)
                .build();
    }

}
