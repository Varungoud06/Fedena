package com.example.school.serviceimpl;

import com.example.school.dto.requestdto.StudentRequestDto;
import com.example.school.dto.responsedto.ApiResponse;
import com.example.school.dto.responsedto.StudentResponseDto;
import com.example.school.entity.Student;
import com.example.school.repo.StudentRepository;
import com.example.school.service.StudentService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentServiceImpl implements StudentService {

    private final StudentRepository studentRepository;

    public StudentServiceImpl(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    @Override
    public ApiResponse<StudentResponseDto> addStudent(StudentRequestDto dto) {

        Student student = new Student();
        student.setName(dto.getName());
        student.setRollNumber(dto.getRollNumber());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());

        Student savedStudent = studentRepository.save(student);

        StudentResponseDto response = mapToDto(savedStudent);

        return ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student added successfully")
                .data(response)
                .build();
    }

    @Override
    public ApiResponse<StudentResponseDto> updateStudent(Long id, StudentRequestDto dto) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        student.setName(dto.getName());
        student.setRollNumber(dto.getRollNumber());
        student.setEmail(dto.getEmail());
        student.setPhone(dto.getPhone());

        Student updatedStudent = studentRepository.save(student);

        return ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student updated successfully")
                .data(mapToDto(updatedStudent))
                .build();
    }

    @Override
    public ApiResponse<StudentResponseDto> getStudentById(Long id) {

        Student student = studentRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Student not found"));

        return ApiResponse.<StudentResponseDto>builder()
                .success(true)
                .message("Student fetched successfully")
                .data(mapToDto(student))
                .build();
    }

    @Override
    public ApiResponse<List<StudentResponseDto>> getAllStudents() {

        List<StudentResponseDto> students = studentRepository.findAll()
                .stream()
                .map(this::mapToDto)
                .toList();

        return ApiResponse.<List<StudentResponseDto>>builder()
                .success(true)
                .message("Students fetched successfully")
                .data(students)
                .build();
    }

    @Override
    public ApiResponse<String> deleteStudent(Long id) {

        studentRepository.deleteById(id);

        return ApiResponse.<String>builder()
                .success(true)
                .message("Student deleted successfully")
                .data("Deleted ID: " + id)
                .build();
    }

    private StudentResponseDto mapToDto(Student student) {

        StudentResponseDto dto = new StudentResponseDto();
        dto.setId(student.getId());
        dto.setName(student.getName());
        dto.setRollNumber(student.getRollNumber());
        dto.setEmail(student.getEmail());
        dto.setPhone(student.getPhone());

        return dto;
    }
}