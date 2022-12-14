package com.example.barogo.dto;

import lombok.Getter;
import lombok.Setter;
import com.example.barogo.enumeration.UserRole;

@Getter
@Setter
public class OrderRequest {

    private Long id;

    private Long userId;

    private String address;

    private boolean isChangeable;

    private LocaldateTime createDateTime;

    private LocaldateTime updateDateTime;

}
