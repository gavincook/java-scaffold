package com.example.biz.domain.model;

import lombok.Data;

import java.time.Instant;

@Data
public class User {
    private String id;
    private String username;
    private String password;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
}

