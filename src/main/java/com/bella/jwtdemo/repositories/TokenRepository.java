package com.bella.jwtdemo.repositories;

import com.bella.jwtdemo.models.Token;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface TokenRepository extends JpaRepository<Token, Long> {
    Optional<Token> findByAccessToken(String accessToken);

    Optional<Token> findByRefreshToken(String refreshToken);

    //select all tokens based on the user id
    List<Token> findAllByUserId(Long userId);
}
