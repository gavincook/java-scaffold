package com.example.biz.api.controller;

import com.example.base.api.response.CommonResponse;
import com.example.biz.api.response.UserVo;
import com.example.biz.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
@RequestMapping("/users")
public class UserController {

    private final UserApplicationService userApplicationService;

    @GetMapping("/{id}")
    public CommonResponse<UserVo> getUser(@PathVariable String id) {
        return CommonResponse.success(userApplicationService.getUser(id));
    }
}
