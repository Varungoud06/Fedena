package com.example.school.serviceimpl;
import com.example.school.dto.requestdto.UserRequestDTO;
import com.example.school.dto.responsedto.UserResponseDTO;
import com.example.school.entity.User;
import com.example.school.repo.UserRepository;
import com.example.school.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    private final UserRepository userRepository;

    @Autowired
    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserResponseDTO createUser(UserRequestDTO dto) {
        User user = new User();
        user.setUsername(dto.getUsername());
        user.setPassword(dto.getPassword()); // ⚠️ Use BCryptPasswordEncoder in real apps
        user.setRole(dto.getRole());

        User saved = userRepository.save(user);
        return new UserResponseDTO(saved.getId(), saved.getUsername(), saved.getRole());
    }

    @Override
    public List<UserResponseDTO> getAllUsers() {
        return userRepository.findAll()
                .stream()
                .map(u -> new UserResponseDTO(u.getId(), u.getUsername(), u.getRole()))
                .toList();
    }

    @Override
    public UserResponseDTO getUserById(Long id) {
        User u = userRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("User not found with id: " + id));
        return new UserResponseDTO(u.getId(), u.getUsername(), u.getRole());
    }

    @Override
    public void deleteUser(Long id) {
        userRepository.deleteById(id);
    }
}
