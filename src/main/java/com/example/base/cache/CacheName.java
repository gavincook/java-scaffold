package com.example.base.cache;

import lombok.Getter;

@Getter
public enum CacheName {
    TOKEN("token", "token::");

    private final String name;
    private final String prefix;

    CacheName(String name, String prefix) {
        this.name = name;
        this.prefix = prefix;
    }
}
