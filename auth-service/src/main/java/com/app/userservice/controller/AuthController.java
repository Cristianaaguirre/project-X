package com.app.userservice.controller;

import com.app.userservice.models.dto.RegisterDTO;
import com.app.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping("/register")
    private ResponseEntity<?> register(@RequestBody RegisterDTO register) {
        userService.registerUser(register);
        return ResponseEntity.status(201).build();
    }

}
