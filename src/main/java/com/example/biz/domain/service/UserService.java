package com.example.biz.domain.service;

import com.example.biz.domain.model.User;
import com.example.biz.mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@Slf4j
@RequiredArgsConstructor
public class UserService {

    private final UserMapper userMapper;

    public Optional<User> getUser(String userId) {
        log.info("Retrieving user with ID: {}", userId);
        return Optional.ofNullable(userMapper.selectById(userId));
    }
}
