package com.app.userservice.controller;

import com.app.userservice.models.dto.AuthRequest;
import com.app.userservice.models.dto.RegisterDTO;
import com.app.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO register) {
        userService.registerUser(register);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(userService.loginUser(authRequest));
    }

    @GetMapping("/1")
    public String test() {
        return "I can read this message";
    }

    @GetMapping("/2")
    public String test2() {
        return "I can't read this message without authorization";
    }
}
