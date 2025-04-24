package com.example.biz.api.request;

import lombok.Data;
import org.hibernate.validator.constraints.Length;

@Data
public class LoginCommand {
    @Length(min = 3, max = 20, message = "Username length must be between 3 and 20 characters")
    private String username;

    @Length(min = 6, max = 20, message = "Password length must be between 6 and 20 characters")
    private String password;
}
