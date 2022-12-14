package com.example.barogo.service;

import java.util.List;

public interface UsersService {
    UserDTO createUser(UserRequest userRequest);

    UserDTO findByEmailAndPassword(String email, String password);
}
