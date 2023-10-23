package com.travel.planner.service;

import com.travel.planner.dto.TripDTO;
import com.travel.planner.entity.Trip;
import com.travel.planner.exception.CustomException;
import com.travel.planner.repository.TripRepository;
import com.travel.planner.utils.TripMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class TripServiceImpl implements TripService{
    private final TripRepository tripRepository;
    private final TripMapper tripMapper;
    public TripServiceImpl(TripRepository tripRepository, TripMapper tripMapper) {
        this.tripRepository = tripRepository;
        this.tripMapper = tripMapper;
    }

    @Transactional
    @Override
    public TripDTO createTrip(TripDTO tripDTO) {
        Trip trip = tripMapper.toEntity(tripDTO);
        trip = tripRepository.save(trip);
        return tripMapper.toDTO(trip);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<TripDTO> getTrip(Long id) {
        return tripRepository.findById(id).map(tripMapper::toDTO);
    }
    @Transactional
    @Override
    public TripDTO updateTrip(Long id, TripDTO tripDTO) {
        if (tripRepository.existsById(id)) {
            Trip trip = tripMapper.toEntity(tripDTO);
            trip.setId(id);
            trip = tripRepository.save(trip);
            return tripMapper.toDTO(trip);
        }
        return null;
    }
    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public TripDTO deleteTrip(Long id) {
        tripRepository.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);
    }

    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<TripDTO> findAllTrips() {
        return tripRepository.findAll()
                .stream()
                .map(tripMapper::toDTO)
                .collect(Collectors.toList());
    }
}
