package com.example.barogo.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.barogo.enumeration.UserRole;

@Getter
@Setter
public class UserRequest {

    private String email;

    private String passWord;

    private UserRole userRole;

}
