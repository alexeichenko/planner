package com.travel.planner.unit;

import com.travel.planner.dto.TripDTO;
import com.travel.planner.entity.Trip;
import com.travel.planner.utils.TripMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class TripMapperTest {
    private TripMapper tripMapper;
    @BeforeEach
    public void setUp() {
        tripMapper = new TripMapper();
    }
    @Test
    public void testToDTO() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Test Name");
        trip.setDescription("Test Description");
        TripDTO dto = tripMapper.toDTO(trip);
        assertEquals(1L, dto.getId());
        assertEquals("Test Name", dto.getName());
        assertEquals("Test Description", dto.getDescription());
    }

    @Test
    public void testToEntity() {
        TripDTO dto = new TripDTO();
        dto.setId(1L);
        dto.setName("Test Name");
        dto.setDescription("Test Description");
        Trip trip = tripMapper.toEntity(dto);
        assertEquals(1L, trip.getId());
        assertEquals("Test Name", trip.getName());
        assertEquals("Test Description", trip.getDescription());
    }
}
