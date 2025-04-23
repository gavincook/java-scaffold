package com.example.biz.application.service;

import com.example.biz.api.response.UserVo;
import com.example.biz.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    private final UserService userService;

    public UserVo getUser(String userId) {
        return userService.getUser(userId).map(UserVo::of).orElse(null);
    }
}
