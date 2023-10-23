package com.travel.planner.unit;

import com.travel.planner.dto.RoleDTO;
import com.travel.planner.dto.UserDTO;
import com.travel.planner.entity.Role;
import com.travel.planner.entity.User;
import com.travel.planner.utils.RoleMapper;
import com.travel.planner.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class RoleMapperTest {
    private RoleMapper roleMapper;
    @BeforeEach
    public void setUp() {
        roleMapper = new RoleMapper();
    }

    @Test
    public void testToDTO() {
        Role role = new Role();
        role.setId(1L);
        role.setName("USER");
        RoleDTO dto = roleMapper.roleToDTO(role);
        assertEquals(1L, dto.getId());
        assertEquals("USER", dto.getName());
    }

    @Test
    public void testToEntity() {
        RoleDTO dto = new RoleDTO();
        dto.setId(1L);
        dto.setName("USER");
        Role role = roleMapper.roleToEntity(dto);
        assertEquals(1L, role.getId());
        assertEquals("USER", role.getName());
    }
}
