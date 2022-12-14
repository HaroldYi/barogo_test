package com.example.barogo.service;

import java.util.List;

public interface OrderService {

    OrderDTO modifyOrder(OrderRequest orderRequest);

    List<Order> findByCreateDate(LocaldateTime createDateTime);
}
