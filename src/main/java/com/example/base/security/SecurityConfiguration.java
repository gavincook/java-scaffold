package com.example.base.security;

import com.example.biz.application.service.UserApplicationService;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configurers.AbstractHttpConfigurer;
import org.springframework.security.config.http.SessionCreationPolicy;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.security.web.SecurityFilterChain;
import org.springframework.security.web.authentication.UsernamePasswordAuthenticationFilter;

@Configuration
@RequiredArgsConstructor
public class SecurityConfiguration {

    @Bean
    public SecurityFilterChain securityFilterChain(HttpSecurity http,
                                                   UserApplicationService userApplicationService) throws Exception {
        http.csrf(AbstractHttpConfigurer::disable)
                .sessionManagement(s ->                   // 无状态
                        s.sessionCreationPolicy(SessionCreationPolicy.STATELESS)
                )
                .authorizeHttpRequests(auth -> auth
                        .requestMatchers("/auth/login").permitAll() // 登录接口不需要认证
                        .anyRequest().authenticated() // 其他请求需要认证
                )
                .exceptionHandling(ex ->
                        ex.authenticationEntryPoint(new AuthEntryPoint())
                )
                .addFilterBefore(
                        new TokenAuthenticationFilter(userApplicationService),
                        UsernamePasswordAuthenticationFilter.class);
        
        return http.build();
    }

    @Bean
    public PasswordEncoder passwordEncoder() {
        return new BCryptPasswordEncoder();
    }
}
