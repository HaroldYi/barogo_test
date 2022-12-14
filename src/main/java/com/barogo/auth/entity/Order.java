package com.example.barogo.entity;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Entity
public class Order {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column
    private Long id;

    @Column
    private Long userId;

    @Column
    private String address;

    @Column
    private boolean isChangeable;

    @Column
    private LocaldateTime createDateTime;

    @Column
    private LocaldateTime updateDateTime;

    private Order(Long id, Long userId, String address, boolean isChangeable, LocaldateTime createDateTime, LocaldateTime updateDateTime) {
        this.id = id;
        this.userId = userId;
        this.address = address;
        this.isChangeable = isChangeable;
        this.createDateTime = createDateTime;
        this.updateDateTime = updateDateTime;
    }
}
