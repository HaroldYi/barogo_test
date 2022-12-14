package com.example.barogo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.example.barogo.entity.Users;

@Repository
public interface UserRepository extends JpaRepository<Users, Long> {

    Users findByEmailAndPassword(String email, String password);
}