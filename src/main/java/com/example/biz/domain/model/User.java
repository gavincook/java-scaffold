package com.example.biz.domain.model;

import lombok.Data;

import java.time.Instant;

@Data
public class User {
    private Long id;
    private String name;
    private String password;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;
}

