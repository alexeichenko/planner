package com.travel.planner.unit;

import com.travel.planner.dto.UserDTO;
import com.travel.planner.entity.User;
import com.travel.planner.repository.UserJpaRepository;
import com.travel.planner.service.UserServiceImpl;
import com.travel.planner.utils.UserMapper;
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

public class UserServiceImplTest {
    @Mock
    private UserJpaRepository userRepository;
    @Spy
    private UserMapper userMapper;
    @InjectMocks
    private UserServiceImpl userService;

    @BeforeEach
    public void setUp() {
        MockitoAnnotations.openMocks(this);
    }
    @Test
    public void testCreateUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Test User");
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("test@example.com");
        userDTO.setName("Test User");
        when(userRepository.save(any())).thenReturn(user);
        UserDTO resultDTO = userService.createUser(userDTO);
        verify(userRepository, times(1)).save(any(User.class));
        assertEquals(1L, resultDTO.getId());
        verify(userMapper, times(1)).toEntity(userDTO);
        verify(userMapper, times(1)).toDTO(user);
    }

    @Test
    public void testGetUser() {
        User user = new User();
        user.setId(1L);
        user.setEmail("test@example.com");
        user.setName("Test User");
        UserDTO userDTO = new UserDTO();
        userDTO.setId(1L);
        userDTO.setEmail("test@example.com");
        userDTO.setName("Test User");
        given(userRepository.findById(1L)).willReturn(Optional.of(user));
        Optional<UserDTO> resultDTO = userService.getUser(1L);
        assertTrue(resultDTO.isPresent());
        assertEquals(1L, resultDTO.get().getId());
        verify(userMapper, times(1)).toDTO(user);
    }
}
