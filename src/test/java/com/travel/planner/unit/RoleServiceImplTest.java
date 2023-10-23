package com.travel.planner.unit;

import com.travel.planner.dto.RoleDTO;
import com.travel.planner.entity.Role;;
import com.travel.planner.repository.RoleRepository;
import com.travel.planner.service.RoleServiceImpl;
import com.travel.planner.utils.RoleMapper;
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

public class RoleServiceImplTest {
    @Mock
    private RoleRepository roleRepository;
    @Spy
    private RoleMapper roleMapper;
    @InjectMocks
    private RoleServiceImpl roleService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    public void testCreateRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("USER");
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        roleDTO.setName("USER");
        when(roleRepository.save(any())).thenReturn(role);
        RoleDTO resultDTO = roleService.createRole(roleDTO);
        verify(roleRepository, times(1)).save(any(Role.class));
        assertEquals(1L, resultDTO.getId());
        verify(roleMapper, times(1)).roleToEntity(roleDTO);
        verify(roleMapper, times(1)).roleToDTO(role);
    }

    @Test
    public void testGetRole() {
        Role role = new Role();
        role.setId(1L);
        role.setName("USER");
        RoleDTO roleDTO = new RoleDTO();
        roleDTO.setId(1L);
        roleDTO.setName("USER");
        given(roleRepository.findById(1L)).willReturn(Optional.of(role));
        Optional<RoleDTO> resultDTO = roleService.getRole(1L);
        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());
        verify(roleMapper, times(1)).roleToDTO(role);
    }
}
