package com.bella.jwtdemo.controllers;

import com.bella.jwtdemo.models.User;
import com.bella.jwtdemo.responses.AuthenticationResponse;
import com.bella.jwtdemo.services.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AuthController {
    private final AuthService authService;

    public AuthController(AuthService authService) {
        this.authService = authService;
    }

    @PostMapping("/auth/v1/register")
    public ResponseEntity<AuthenticationResponse> register(@RequestBody  User request) {
        return ResponseEntity.ok(authService.register(request));
    }

    @PostMapping("/auth/v1/login")
    public ResponseEntity<AuthenticationResponse> login(@RequestBody User request) {
        return ResponseEntity.ok(authService.authenticate(request));
    }

    @PostMapping("/oauth2/v1/token")
    public ResponseEntity<AuthenticationResponse> refreshToken(
            HttpServletRequest request,
            HttpServletResponse response) {
        return authService.refreshToken(request, response);
    }
}
