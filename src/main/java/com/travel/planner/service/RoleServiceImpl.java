package com.travel.planner.service;

import com.travel.planner.dto.RoleDTO;
import com.travel.planner.entity.Role;
import com.travel.planner.exception.CustomException;
import com.travel.planner.repository.RoleRepository;
import com.travel.planner.utils.RoleMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Isolation;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
@Service
public class RoleServiceImpl implements RoleService{
    private final RoleRepository roleRepository;
    private final RoleMapper roleMapper;

    public RoleServiceImpl(RoleRepository roleRepository, RoleMapper roleMapper) {
        this.roleRepository = roleRepository;
        this.roleMapper = roleMapper;
    }

    @Transactional
    @Override
    public RoleDTO createRole(RoleDTO roleDTO) {
        Role role = roleMapper.roleToEntity(roleDTO);
        role = roleRepository.save(role);
        return roleMapper.roleToDTO(role);
    }
    @Transactional(readOnly = true)
    @Override
    public Optional<RoleDTO> getRole(Long id) {
        return roleRepository.findById(id).map(roleMapper::roleToDTO);
    }

    @Transactional
    @Override
    public RoleDTO updateRole(Long id, RoleDTO roleDTO) {
        if (roleRepository.existsById(id)) {
            Role role = roleMapper.roleToEntity(roleDTO);
            role.setId(id);
            role = roleRepository.save(role);
            return roleMapper.roleToDTO(role);
        }
        return null;
    }
    @Transactional(rollbackFor = CustomException.class, propagation = Propagation.REQUIRED)
    @Override
    public void deleteRole(Long id) {
        roleRepository.deleteById(id);
        throw new CustomException("deleted wrong should be rollback", 500);
    }
    @Transactional(readOnly = true, isolation = Isolation.REPEATABLE_READ)
    @Override
    public List<RoleDTO> findAllRoles() {
        return roleRepository.findAll()
                .stream()
                .map(roleMapper::roleToDTO)
                .collect(Collectors.toList());
    }
}
