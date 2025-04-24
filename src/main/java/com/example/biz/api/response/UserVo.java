package com.example.biz.api.response;

import com.example.biz.domain.model.User;
import lombok.Getter;
import lombok.Setter;

import java.time.Instant;
import java.util.Objects;

@Getter
@Setter
public class UserVo {
    private String id;
    private String name;
    private String email;
    private Instant createdAt;
    private Instant updatedAt;

    public static UserVo of(User user) {
        if (Objects.isNull(user)) {
            return null;
        }

        UserVo response = new UserVo();
        response.setId(user.getId());
        response.setName(user.getName());
        response.setEmail(user.getEmail());
        response.setCreatedAt(user.getCreatedAt());
        response.setUpdatedAt(user.getUpdatedAt());
        return response;
    }
}
