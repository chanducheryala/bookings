package com.example.booking.demo.repository;

import com.example.booking.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface MyUserDetailsRepository extends JpaRepository<User, UUID> {
    User findByUsername(String username);
}
