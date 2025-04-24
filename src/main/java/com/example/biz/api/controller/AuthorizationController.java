package com.example.biz.api.controller;

import com.example.base.api.response.CommonResponse;
import com.example.biz.api.request.LoginCommand;
import com.example.biz.application.service.UserApplicationService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
@RequiredArgsConstructor
public class AuthorizationController {

    private final UserApplicationService userApplicationService;

    @PostMapping("/login")
    public CommonResponse<String> login(@RequestBody @Valid LoginCommand loginCommand) {
        String token = userApplicationService.login(loginCommand);
        return CommonResponse.success(token);
    }
}
