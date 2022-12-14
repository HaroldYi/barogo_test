package com.example.barogo.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.example.barogo.JwtConfig;
import com.example.barogo.dto.OrderDTO;
import com.example.barogo.dto.OrderRequest;
import com.example.barogo.service.impl.OrderServiceImpl;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/v1/order")
@RequiredArgsConstructor
public class UsersController {

    private final OrderServiceImpl orderService;

    @PostMapping("/{id}")
    public OrderDTO modifyOrder(@PathVariable("id") Long id, OrderRequest orderRequest) {
        orderRequest.setId(id);
        return orderService.modifyOrder(orderRequest);
    }

    @getMapping("/")
    public List<Order> getOrderLost(OrderRequest orderRequest) {
        return orderService.modifyOrder(orderRequest.getCreateDateTime());
    }

}
