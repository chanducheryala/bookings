package com.example.booking.demo.repository;

import com.example.booking.demo.model.SubLocation;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface SubLocationRepository extends JpaRepository<SubLocation, Long> {
}
