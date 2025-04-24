package com.example.biz.application.service;

import com.example.biz.api.request.LoginCommand;
import com.example.biz.api.response.UserVo;
import com.example.biz.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    private final UserService userService;

    public UserVo getUser(String userId) {
        return userService.getUser(userId).map(UserVo::of).orElse(null);
    }

    public String login(LoginCommand loginCommand) {
        String username = loginCommand.getUsername();
        String password = loginCommand.getPassword();
        return userService.login(username, password)
                .map(user -> UUID.randomUUID().toString())
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }
}
