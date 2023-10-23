package com.travel.planner.repository;

import com.travel.planner.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface TripRepository extends JpaRepository<Trip, Long> {
    Optional<Trip> findByName(String name);
    Optional<Trip> findByDescription(String description);
}
