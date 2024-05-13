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

    @Column(name = "token")
    private String token;

    @Column(name = "is_logged_out")
    private boolean isLoggedOut = false;

    @ManyToOne
    @JoinColumn(name = "user_id")
    private User user;

}
