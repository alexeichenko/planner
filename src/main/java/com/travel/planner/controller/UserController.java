package com.travel.planner.controller;

import com.travel.planner.dto.UserDTO;
import com.travel.planner.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    // Authorised users features

    // Create user
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/create")
    public ResponseEntity<UserDTO> createUser(@RequestBody UserDTO userDTO) {
        return ResponseEntity.ok(userService.createUser(userDTO));
    }
    // Get user by id from URL
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/id/{userId}")
    public ResponseEntity<Optional<UserDTO>> getUser(@PathVariable("userId") Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
    // Get user by id from request parameter
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/id/")
    public ResponseEntity<Optional<UserDTO>> getUserRequestParam(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(userService.getUser(userId));
    }
    @PreAuthorize("hasRole('USER')")
    @PostMapping("/user/id/update")
    public ResponseEntity<UserDTO> updateUserRequestParam(@RequestParam("userId") Long userId) {
        UserDTO userDTO = new UserDTO();
        return ResponseEntity.ok(userService.updateUser(userId, userDTO));
    }


    // Authorised admins features

    // Delete user
    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/id/delete")
    public ResponseEntity<UserDTO> deleteUserRequestParam(@RequestParam("userId") Long userId) {
        return ResponseEntity.ok(userService.deleteUser(userId));
    }

    @PreAuthorize("hasRole('ADMIN')")
    @PostMapping("/user/find")
    public ResponseEntity<UserDTO> findUsersRequestParam(@RequestParam UserDTO userDTO) {
        return ResponseEntity.ok((UserDTO) userService.findAllUsers());
    }
}
