package com.example.barogo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.barogo.enumeration.UserRole;

@Getter
@Setter
@NoArgsConstructor
public class UserDTO {

    private Long id;

    private String email;

    private String password;

    private UserRole userRole;

    @Builder
    private UserDTO(Long id, String password, UserRole userRole, String , LocaldateTime createDateTime, LocaldateTime updateDateTime) {
        this.id = id;
        this.password = password;
        this.userRole = userRole;
        this.email = email;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

}
