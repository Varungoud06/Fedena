package com.example.school.service;

import com.example.school.dto.requestdto.UserRequestDTO;
import com.example.school.dto.responsedto.UserResponseDTO;

import java.util.List;

public interface UserService {
    UserResponseDTO createUser(UserRequestDTO dto);
    List<UserResponseDTO> getAllUsers();
    UserResponseDTO getUserById(Long id);
    void deleteUser(Long id);
}
