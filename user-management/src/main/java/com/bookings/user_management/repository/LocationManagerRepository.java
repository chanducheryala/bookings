package com.bookings.user_management.repository;

import com.bookings.user_management.model.LocationManager;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface LocationManagerRepository extends JpaRepository<LocationManager, Long> {
}