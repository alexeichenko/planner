package com.travel.planner.service;

import com.travel.planner.dto.TripDTO;

import java.util.List;
import java.util.Optional;

public interface TripService {
    TripDTO createTrip (TripDTO tripDTO);
    Optional<TripDTO> getTrip (Long id);
    TripDTO updateTrip (Long id, TripDTO tripDTO);
    TripDTO deleteTrip (Long id);
    List<TripDTO> findAllTrips();
}
