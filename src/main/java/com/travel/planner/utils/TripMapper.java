package com.travel.planner.utils;

import com.travel.planner.dto.TripDTO;
import com.travel.planner.entity.Trip;
import org.springframework.stereotype.Component;

@Component
public class TripMapper {
    public TripDTO toDTO (Trip trip) {
        TripDTO dto = new TripDTO();
        dto.setId(trip.getId());
        dto.setName(trip.getName());
        dto.setDescription(trip.getDescription());
        return dto;
    }

    public Trip toEntity (TripDTO tripDTO) {
        Trip trip = new Trip();
        trip.setId(tripDTO.getId());
        trip.setName(tripDTO.getName());
        trip.setDescription(tripDTO.getDescription());
        return trip;
    }
}
