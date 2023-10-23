package com.travel.planner.utils;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.entity.Route;
import org.springframework.stereotype.Component;

@Component
public class RouteMapper {
    public RouteDTO toDTO (Route route) {
        RouteDTO dto = new RouteDTO();
        dto.setId(route.getId());
        dto.setName(route.getName());
        dto.setDescription(route.getDescription());
        return dto;
    }

    public Route toEntity (RouteDTO routeDTO) {
        Route route = new Route();
        route.setId(routeDTO.getId());
        route.setName(routeDTO.getName());
        route.setDescription(routeDTO.getDescription());
        return route;
    }
}
