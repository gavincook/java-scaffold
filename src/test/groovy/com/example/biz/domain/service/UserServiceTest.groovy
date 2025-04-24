package com.example.biz.domain.service

import com.example.biz.domain.model.User
import com.example.biz.mapper.UserMapper
import org.springframework.security.crypto.password.PasswordEncoder
import spock.lang.Specification

class UserServiceTest extends Specification {
    private UserMapper userMapper = Mock(UserMapper)
    private PasswordEncoder passwordEncoder = Mock(PasswordEncoder)

    private UserService userService = new UserService(userMapper, passwordEncoder)

    def "getUser -- should get user by id"() {

        given:
        def userId = 1 as String

        when:
        def optionalUser = userService.getUser(userId)

        then:
        1 * userMapper.selectById(userId) >> new User(id: userId, username: "John Doe")
        optionalUser.isPresent()
        optionalUser.get().with {
            verifyAll {
                id == userId
                username == "John Doe"
            }
        }

    }
}
