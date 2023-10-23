package com.travel.planner.unit;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.entity.Route;
import com.travel.planner.repository.RouteRepository;
import com.travel.planner.service.RouteServiceImpl;
import com.travel.planner.utils.RouteMapper;
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

public class RouteServiceImplTest {
    @Mock
    private RouteRepository routeRepository;
    @Spy
    private RouteMapper routeMapper;
    @InjectMocks
    private RouteServiceImpl routeService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRoute() {
        Route route = new Route();
        route.setId(1L);
        route.setName("Test name");
        route.setDescription("Test description");
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(1L);
        routeDTO.setName("Test name");
        routeDTO.setDescription("Test description");
        when(routeRepository.save(any())).thenReturn(route);
        RouteDTO resultDTO = routeService.createRoute(routeDTO);
        verify(routeRepository, times(1)).save(any(Route.class));
        assertEquals(1L, resultDTO.getId());
        verify(routeMapper, times(1)).toEntity(routeDTO);
        verify(routeMapper, times(1)).toDTO(route);
    }

    @Test
    public void testGetRoute() {
        Route route = new Route();
        route.setId(1L);
        route.setName("Test name");
        route.setDescription("Test description");
        RouteDTO routeDTO = new RouteDTO();
        routeDTO.setId(1L);
        routeDTO.setName("Test name");
        routeDTO.setDescription("Test description");
        given(routeRepository.findById(1L)).willReturn(Optional.of(route));
        Optional<RouteDTO> resultDTO = routeService.getRoute(1L);
        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());
        verify(routeMapper, times(1)).toDTO(route);
    }
}
