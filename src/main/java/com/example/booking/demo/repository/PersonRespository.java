package com.example.booking.demo.repository;

import com.example.booking.demo.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;


@Repository
public interface PersonRespository extends JpaRepository<Person, Long> {
    Optional<Person> findByEmail(String email);
}
