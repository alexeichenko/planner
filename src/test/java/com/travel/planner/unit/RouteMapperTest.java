package com.travel.planner.unit;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.entity.Route;
import com.travel.planner.utils.RouteMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RouteMapperTest {
    private RouteMapper routeMapper;
    @BeforeEach
    public void setUp() {
        routeMapper = new RouteMapper();
    }

    @Test
    public void testToDTO() {
        Route route = new Route();
        route.setId(1L);
        route.setName("Test Name");
        route.setDescription("Test Description");
        RouteDTO dto = routeMapper.toDTO(route);
        assertEquals(1L, dto.getId());
        assertEquals("Test Name", dto.getName());
        assertEquals("Test Description", dto.getDescription());
    }

    @Test
    public void testToEntity() {
        RouteDTO dto = new RouteDTO();
        dto.setId(1L);
        dto.setName("Test Name");
        dto.setDescription("Test Description");
        Route route = routeMapper.toEntity(dto);
        assertEquals(1L, route.getId());
        assertEquals("Test Name", route.getName());
        assertEquals("Test Description", route.getDescription());
    }
}
