package com.travel.planner.service;

import com.travel.planner.dto.UserDTO;

import java.util.List;
import java.util.Optional;

public interface UserService {
    UserDTO createUser (UserDTO userDTO);
    Optional<UserDTO> getUser(Long id);
    UserDTO updateUser(Long id, UserDTO userDTO);
    UserDTO deleteUser(Long id);
    List<UserDTO> findAllUsers();
}
