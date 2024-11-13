package com.example.booking.demo.repository;

import com.example.booking.demo.model.LocationSubManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationSubManagerRepository extends JpaRepository<LocationSubManager, Long> {
}
