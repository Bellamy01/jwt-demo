package com.bella.jwtdemo.controllers;

import com.bella.jwtdemo.models.Token;
import com.bella.jwtdemo.repositories.TokenRepository;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class TokenController {
    private final TokenRepository tokenRepository;

    public TokenController(TokenRepository tokenRepository) {
        this.tokenRepository = tokenRepository;
    }

    @GetMapping("/tokens")
    public ResponseEntity<List<Token>> getTokens() {
        return ResponseEntity.ok(tokenRepository.findAll());
    }

    @GetMapping("/tokens/user/{userId}")
    public ResponseEntity<List<Token>> getTokensByUserId(@PathVariable Long userId) {
        return ResponseEntity.ok(tokenRepository.findAllByUserId(userId));
    }
}
