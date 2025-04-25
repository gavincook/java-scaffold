package com.example.base.security;

import com.example.biz.domain.model.User;

import java.util.Optional;

public class CurrentUserHolder {
    private static final ThreadLocal<User> USER_THREAD_LOCAL = new ThreadLocal<>();

    public static void setUser(User user) {
        USER_THREAD_LOCAL.set(user);
    }

    public static Optional<User> getUser() {
        return Optional.ofNullable(USER_THREAD_LOCAL.get());
    }

    public static void clear() {
        USER_THREAD_LOCAL.remove();
    }
}
