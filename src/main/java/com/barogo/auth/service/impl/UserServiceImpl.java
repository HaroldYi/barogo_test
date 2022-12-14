package com.example.barogo.service.impl;

import lombok.RequiredArgsConstructor;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import com.example.barogo.dto.UserRequest;
import com.example.barogo.jwt.entity.Users;
import com.example.barogo.jwt.repository.UserRepository;
import com.example.barogo.jwt.service.UsersService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UsersService {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDTO createUser(UserRequest userRequest) {
        Users users = userRepository.save(
                Users.builder().password(bCryptPasswordEncoder.encode(userRequest.getPassWord())).email(userRequest.getEmail()).userRole(userRequest.getUserRole()).build());
        return UserDTO.builder().id(users.getId()).password(users.getPassword()).userRole(users.getUserRole()).email(users.getEmail()).build();
    }

    @Override
    public UserDTO findByEmailAndPassword(String email, String password) {
        Users users = Optional.ofNullable(userRepository.findByEmail(email)).orElseThrow(()->new BadCredentialsException("이메일이나 비밀번호를 확인해주세요."));

        if (bCryptPasswordEncoder.matches(password, users.getPassword()) == false) {
            throw new BadCredentialsException("비밀번호가 일치하지 않습니다.");
        }

        return UserDTO.builder().id(users.getId()).password(users.getPassword()).userRole(users.getUserRole()).email(users.getEmail()).build();
    }
}
