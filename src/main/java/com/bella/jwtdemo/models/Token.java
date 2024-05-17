package com.bella.jwtdemo.models;

import jakarta.persistence.*;
import lombok.*;

@Table
@Entity(name = "tokens")
@Getter
@Setter
@RequiredArgsConstructor
public class Token {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "access_token")
    private String accessToken;

    @Column(name = "refresh_token")
    private String refreshToken;

    @Column(name = "is_logged_out")
    private boolean isLoggedOut = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
