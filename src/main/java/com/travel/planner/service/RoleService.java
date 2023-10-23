package com.travel.planner.service;

import com.travel.planner.dto.RoleDTO;
import com.travel.planner.dto.UserDTO;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

public interface RoleService {
    RoleDTO createRole (RoleDTO roleDTO);
    Optional<RoleDTO> getRole(Long id);
    RoleDTO updateRole(Long id, RoleDTO roleDTO);
    void deleteRole (Long id);
    List<RoleDTO> findAllRoles();
}
