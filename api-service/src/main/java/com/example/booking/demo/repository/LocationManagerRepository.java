package com.example.booking.demo.repository;

import com.example.booking.demo.model.LocationManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationManagerRepository extends JpaRepository<LocationManager, Long> {
}
