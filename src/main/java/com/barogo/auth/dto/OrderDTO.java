package com.example.barogo.dto;

import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import com.example.barogo.enumeration.UserRole;

@Getter
@Setter
@NoArgsConstructor
public class OrderDTO {

    private Long id;

    private Long userId;

    private String address;

    private boolean isChangeable;

    private LocaldateTime createDateTime;

    private LocaldateTime updateDateTime;

    private OrderDTO(Long id, Long userId, String address, boolean isChangeable, LocaldateTime createDateTime, LocaldateTime updateDateTime) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.isChangeable = isChangeable;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }

}
