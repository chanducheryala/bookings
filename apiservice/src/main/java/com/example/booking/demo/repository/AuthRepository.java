package com.example.booking.demo.repository;

import com.example.booking.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AuthRepository extends JpaRepository<Person, Long> {
    Person findByEmail(String email);
}
