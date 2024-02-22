package com.app.userservice.models;

import com.app.userservice.models.Role;
import com.app.userservice.controller.dto.RegisterDTO;
import com.app.userservice.models.UserEntity;

import java.util.UUID;

public class UserMapper {


    public static UserEntity dtoToEntity(RegisterDTO dto) {
        return UserEntity.builder()
                .id(UUID.randomUUID())
                .username(dto.getUsername())
                .email(dto.getEmail())
                .role(Role.USER)
                .build();
    }

}
