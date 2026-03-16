package com.example.school.controller;

import com.example.school.dto.requestdto.UserRequestDTO;
import com.example.school.dto.responsedto.ApiResponse;
import com.example.school.dto.responsedto.UserResponseDTO;
import com.example.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ApiResponse<UserResponseDTO> create(@RequestBody UserRequestDTO dto) {
        UserResponseDTO user = userService.createUser(dto);
        return new ApiResponse<>(true, "User created successfully", user);
    }

    @GetMapping
    public ApiResponse<List<UserResponseDTO>> getAll() {
        List<UserResponseDTO> users = userService.getAllUsers();
        return new ApiResponse<>(true, "Fetched all users", users);
    }

    @GetMapping("/{id}")
    public ApiResponse<UserResponseDTO> getById(@PathVariable Long id) {
        UserResponseDTO user = userService.getUserById(id);
        return new ApiResponse<>(true, "Fetched user by ID", user);
    }

    @DeleteMapping("/{id}")
    public ApiResponse<Void> delete(@PathVariable Long id) {
        userService.deleteUser(id);
        return new ApiResponse<>(true, "User deleted successfully", null);
    }
}
