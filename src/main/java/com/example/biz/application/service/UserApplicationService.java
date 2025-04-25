package com.example.biz.application.service;

import com.example.base.cache.CacheHelper;
import com.example.base.cache.CacheName;
import com.example.biz.api.request.LoginCommand;
import com.example.biz.api.response.UserVo;
import com.example.biz.domain.model.User;
import com.example.biz.domain.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.UUID;

@Service
@RequiredArgsConstructor
public class UserApplicationService {
    private final UserService userService;
    private final CacheHelper cacheHelper;

    public UserVo getUser(String userId) {
        return userService.getUser(userId).map(UserVo::of).orElse(null);
    }

    public String login(LoginCommand loginCommand) {
        String username = loginCommand.getUsername();
        String password = loginCommand.getPassword();
        return userService.login(username, password)
                .map(user -> {
                    String token = UUID.randomUUID().toString();
                    cacheHelper.getCache(CacheName.TOKEN).put(token, user);
                    return token;
                })
                .orElseThrow(() -> new RuntimeException("Invalid username or password"));
    }

    public User getUserByToken(String token) {
        return cacheHelper.getCache(CacheName.TOKEN).get(token, User.class);
    }

    public void logout(String token) {
        cacheHelper.getCache(CacheName.TOKEN).evict(token);
    }
}
