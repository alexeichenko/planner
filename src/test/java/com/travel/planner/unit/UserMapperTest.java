package com.travel.planner.unit;

import com.travel.planner.dto.UserDTO;
import com.travel.planner.entity.User;
import com.travel.planner.utils.UserMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class UserMapperTest {
    private UserMapper userMapper;
    @BeforeEach
    public void setUp() {
        userMapper = new UserMapper();
    }

    @Test
    public void testToDTO() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Test User");
        UserDTO dto = userMapper.toDTO(user);
        assertEquals(1L, dto.getId());
        assertEquals("test@example.com", dto.getEmail());
        assertEquals("Test User", dto.getName());
    }

    @Test
    public void testToEntity() {
        UserDTO dto = new UserDTO();
        dto.setId(1L);
        dto.setEmail("test@example.com");
        dto.setName("Test User");
        User user = userMapper.toEntity(dto);
        assertEquals(1L, user.getId());
        assertEquals("test@example.com", user.getEmail());
        assertEquals("Test User", user.getName());
    }
}
