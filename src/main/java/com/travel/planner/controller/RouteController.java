package com.travel.planner.controller;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.service.RouteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class RouteController {
    private final RouteService routeService;
    @Autowired
    public RouteController(RouteService routeService) {
        this.routeService = routeService;
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/route/create")
    public ResponseEntity<RouteDTO> createRoute(@RequestBody RouteDTO routeDTO) {
        return ResponseEntity.ok(routeService.createRoute(routeDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/route/id/{routeId}")
    public ResponseEntity<Optional<RouteDTO>> getTrip(@PathVariable("routeId") Long routeId) {
        return ResponseEntity.ok(routeService.getRoute(routeId));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/id/")
    public ResponseEntity<Optional<RouteDTO>> getRouteRequestParam(@RequestParam("routeId") Long routeId) {
        return ResponseEntity.ok(routeService.getRoute(routeId));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/route/id/update")
    public ResponseEntity<RouteDTO> updateRouteRequestParam(@RequestParam("routeId") Long routeId) {
        RouteDTO routeDTO = new RouteDTO();
        return ResponseEntity.ok(routeService.updateRoute(routeId, routeDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/route/id/delete")
    public ResponseEntity<RouteDTO> deleteRouteRequestParam(@RequestParam("routeId") Long routeId) {
        return ResponseEntity.ok(routeService.deleteRoute(routeId));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/route/find")
    public ResponseEntity<RouteDTO> findRoutesRequestParam(@RequestParam RouteDTO routeDTO) {
        return ResponseEntity.ok((RouteDTO) routeService.findAllRoutes());
    }
}
