package com.example.booking.demo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationSubManagerRepository extends JpaRepository<LocationSubManager, Long> {
}
