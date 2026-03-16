package com.example.school.service;
import com.example.school.dto.requestdto.StudentRequestDto;
import com.example.school.dto.responsedto.ApiResponse;
import com.example.school.dto.responsedto.StudentResponseDto;

import java.util.List;

public interface StudentService {

    ApiResponse<StudentResponseDto> addStudent(StudentRequestDto requestDto);

    ApiResponse<StudentResponseDto> updateStudent(Long id, StudentRequestDto requestDto);

    ApiResponse<StudentResponseDto> getStudentById(Long id);

    ApiResponse<List<StudentResponseDto>> getAllStudents();

    ApiResponse<String> deleteStudent(Long id);
}
