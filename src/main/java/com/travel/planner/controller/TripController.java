package com.travel.planner.controller;

import com.travel.planner.dto.TripDTO;
import com.travel.planner.service.TripService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class TripController {
    private final TripService tripService;
    @Autowired
    public TripController(TripService tripService) {
        this.tripService = tripService;
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/create")
    public ResponseEntity<TripDTO> createTrip(@RequestBody TripDTO tripDTO) {
        return ResponseEntity.ok(tripService.createTrip(tripDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/id/{tripId}")
    public ResponseEntity<Optional<TripDTO>> getTrip(@PathVariable("tripId") Long tripId) {
        return ResponseEntity.ok(tripService.getTrip(tripId));
    }



    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/id/update")
    public ResponseEntity<TripDTO> updateTripRequestParam(@RequestParam("tripId") Long tripId) {
        TripDTO tripDTO = new TripDTO();
        return ResponseEntity.ok(tripService.updateTrip(tripId, tripDTO));
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/id/delete")
    public ResponseEntity<TripDTO> deleteTripRequestParam(@RequestParam("tripId") Long tripId) {
        return ResponseEntity.ok(tripService.deleteTrip(tripId));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/trip/find")
    public ResponseEntity<TripDTO> findTripsRequestParam(@RequestParam TripDTO tripDTO) {
        return ResponseEntity.ok((TripDTO) tripService.findAllTrips());
    }
}
