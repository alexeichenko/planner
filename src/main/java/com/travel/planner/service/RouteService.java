package com.travel.planner.service;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface RouteService {
    RouteDTO createRoute (RouteDTO routeDTO);
    Optional<RouteDTO> getRoute(Long id);
    RouteDTO updateRoute(Long id, RouteDTO routeDTO);
    RouteDTO deleteRoute(Long id);
    List<RouteDTO> findAllRoutes();
}
