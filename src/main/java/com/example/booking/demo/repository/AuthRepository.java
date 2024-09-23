package com.example.booking.demo.repository;

import com.example.booking.demo.model.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

public interface AuthRepository extends JpaRepository<User, UUID> {
}
