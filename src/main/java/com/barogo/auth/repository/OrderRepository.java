package com.example.barogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.barogo.entity.Users;

@Repository
public interface OrderRepository extends JpaRepository<Order, Long> {

    OrderDTO findOrderById(Long id);

    List<OrderDTO> findByCreateDateTime(LocaldateTime createDateTime);
}