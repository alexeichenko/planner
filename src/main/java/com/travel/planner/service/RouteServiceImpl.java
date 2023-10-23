package com.travel.planner.service;

import com.travel.planner.dto.RouteDTO;
import com.travel.planner.entity.Route;
import com.travel.planner.exception.CustomException;
import com.travel.planner.repository.RouteRepository;
import com.travel.planner.utils.RouteMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class RouteServiceImpl implements RouteService{
    private final RouteRepository routeRepository;
    private final RouteMapper routeMapper;

    public RouteServiceImpl(RouteRepository routeRepository, RouteMapper routeMapper) {
        this.routeRepository = routeRepository;
        this.routeMapper = routeMapper;
    }
    @Transactional
    @Override
    public RouteDTO createRoute(RouteDTO routeDTO) {
        Route route = routeMapper.toEntity(routeDTO);
        route = routeRepository.save(route);
        return routeMapper.toDTO(route);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<RouteDTO> getRoute(Long id) {
        return routeRepository.findById(id).map(routeMapper::toDTO);
    }
    @Transactional
    @Override
    public RouteDTO updateRoute(Long id, RouteDTO routeDTO) {
        if (routeRepository.existsById(id)) {
            Route route = routeMapper.toEntity(routeDTO);
            route.setId(id);
            route = routeRepository.save(route);
            return routeMapper.toDTO(route);
        }
        return null;
    }
    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public RouteDTO deleteRoute(Long id) {
        routeRepository.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);
    }
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<RouteDTO> findAllRoutes() {
        return routeRepository.findAll()
                .stream()
                .map(routeMapper::toDTO)
                .collect(Collectors.toList());
    }
}
