package com.example.barogo.service.impl;

import lombok.RequiredArgsConstructor;
import com.example.barogo.dto.OrderRequest;
import com.example.barogo.entity.Order;
import com.example.barogo.repository.OrderRepository;
import com.example.barogo.service.OrderService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class OrderServiceImpl implements OrderService {

    private final OrderRepository orderRepository;



    @Override
    public OrderDTO modifyOrder(OrderRequest orderRequest) {

        Order order = Optional.ofNullable(orderRepository.findOrderById(orderRequest.getId())).orElseThrow(()-> new Exception("주문정보가 없습니다."));
        if(order.isChangeable) {
            order.setAddress(orderRequest.getAddress());
            order.save();
        } else {
            new Exception("주문정보 변경이 불가능합니다.")
        }

        return OrderDTO.builder().id(order.getId()).userId(order.getUserId()).address(users.getAddress()).isChangeable(users.isChangeable()).createDateTime(users.getCreateDateTime()).updateDateTime(users.getUpdateDateTime).build();
    }

    @Override
    public List<Order> findByCreateDate(LocaldateTime createDateTime) {

        if(Duration.between(LocaldateTime.now(), createDateTime).toDays() >= 3) {
            new Exception("최대 3일까지만 검색이 가능합니다.")
        }

        List<Order> orderList = Optional.ofNullable(orderRepository.findByCreateDate(createDateTime)).orElseThrow(()->new Exception("주문정보가 없습니다."));
        return orderList;
    }
}
