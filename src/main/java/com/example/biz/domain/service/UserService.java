package com.example.biz.domain.service;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.example.biz.domain.model.User;
import com.example.biz.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    private final PasswordEncoder passwordEncoder;

    public Optional<User> getUser(String userId) {
        log.info("Retrieving user with ID: {}", userId);
        return Optional.ofNullable(userMapper.selectById(userId));
    }

    public Optional<User> login(String username, String password) {
        log.info("User login attempt with name: {}", username);
        LambdaQueryWrapper<User> queryWrapper = new LambdaQueryWrapper<>();
        queryWrapper.eq(User::getUsername, username);
        return Optional.ofNullable(userMapper.selectOne(queryWrapper))
                .filter(user -> passwordEncoder.matches(password, user.getPassword()));
    }
}
