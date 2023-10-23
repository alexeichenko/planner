package com.travel.planner.unit;

import com.travel.planner.dto.TripDTO;
import com.travel.planner.dto.UserDTO;
import com.travel.planner.entity.Route;
import com.travel.planner.entity.Trip;
import com.travel.planner.entity.User;
import com.travel.planner.repository.RouteRepository;
import com.travel.planner.repository.TripRepository;
import com.travel.planner.service.RouteServiceImpl;
import com.travel.planner.service.TripServiceImpl;
import com.travel.planner.utils.RouteMapper;
import com.travel.planner.utils.TripMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.Spy;

import java.util.Optional;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.*;

public class TripServiceImplTest {
    @Mock
    private TripRepository tripRepository;
    @Spy
    private TripMapper tripMapper;
    @InjectMocks
    private TripServiceImpl tripService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateTrip() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Test name");
        trip.setDescription("Test description");
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("Test name");
        tripDTO.setDescription("Test description");
        when(tripRepository.save(any())).thenReturn(trip);
        TripDTO resultDTO = tripService.createTrip(tripDTO);
        verify(tripRepository, times(1)).save(any(Trip.class));
        assertEquals(1L, resultDTO.getId());
        verify(tripMapper, times(1)).toEntity(tripDTO);
        verify(tripMapper, times(1)).toDTO(trip);
    }

    @Test
    public void testGetTrip() {
        Trip trip = new Trip();
        trip.setId(1L);
        trip.setName("Test name");
        trip.setDescription("Test description");
        TripDTO tripDTO = new TripDTO();
        tripDTO.setId(1L);
        tripDTO.setName("Test name");
        tripDTO.setDescription("Test description");
        given(tripRepository.findById(1L)).willReturn(Optional.of(trip));
        Optional<TripDTO> resultDTO = tripService.getTrip(1L);
        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());
        verify(tripMapper, times(1)).toDTO(trip);
    }

}
