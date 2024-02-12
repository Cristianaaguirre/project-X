package com.app.userservice.models.mapper;

import com.app.userservice.common.security.util.Role;
import com.app.userservice.models.dto.RegisterDTO;
import com.app.userservice.models.entity.UserEntity;

public class UserMapper {


    public static UserEntity dtoToEntity(RegisterDTO dto) {
        return UserEntity.builder()
                .username(dto.getUsername())
                .email(dto.getEmail())
                .role(Role.USER)
                .build();
    }

}
