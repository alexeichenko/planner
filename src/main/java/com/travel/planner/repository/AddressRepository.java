package com.travel.planner.repository;

import com.travel.planner.entity.Address;
import com.travel.planner.entity.Trip;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long> {
    Optional<Trip> findByName(String name);
    Optional<Trip> findByDescription(String description);
}
