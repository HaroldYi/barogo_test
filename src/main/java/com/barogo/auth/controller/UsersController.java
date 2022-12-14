package com.example.barogo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/users")
@RequiredArgsConstructor
public class UsersController {

    private final UserServiceImpl usersService;
    private final JwtConfig jwtConfig;

    @PostMapping("/signup")
    public UserDTO createUser(UserRequest userRequest) {

        String pwPattern = "^(?=.*[A-Za-z])(?=.*[0-9])(?=.*[$@$!%*#?&])[A-Za-z[0-9]$@$!%*#?&]{8,}$";
        if(userRequest.getPassWord().length < 12 || !Pattern.matches(pwPattern, userRequest.getPassWord())) {
            throw new IllegalArgumentException("비밀번호는 영어 대문자, 영어 소문자, 숫자, 특수문자 중 3종류 이상으로 12자리 이상의 문자열이어야 합니다.");
        }

        return usersService.createUser(userRequest);
    }

    @PostMapping("/login")
    public String login(UserRequest userRequest) {
        UserDTO users = usersService.findByEmailAndPassword(userRequest.getEmail(), userRequest.getPassWord());
        return jwtConfig.createToken(users.getEmail(), Arrays.asList(users.getUserRole().getValue()));
    }

}
