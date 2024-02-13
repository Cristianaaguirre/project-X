package com.app.userservice.controller;

import com.app.userservice.controller.dto.AuthRequest;
import com.app.userservice.controller.dto.RegisterDTO;
import com.app.userservice.service.IUserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthController {

    private final IUserService userService;

    @PostMapping("/validate")
    public ResponseEntity<?> validateToken(@RequestBody String token) {
        return ResponseEntity.ok(userService.validate(token));
    }

    @PostMapping("/register")
    public ResponseEntity<?> register(@RequestBody RegisterDTO register) {
        userService.registerUser(register);
        return ResponseEntity.status(201).build();
    }

    @PostMapping("/login")
    public ResponseEntity<?> login(@RequestBody AuthRequest authRequest) {
        return ResponseEntity.ok(userService.loginUser(authRequest));
    }

}
