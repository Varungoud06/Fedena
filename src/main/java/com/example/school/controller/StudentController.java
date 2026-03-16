package com.example.school.controller;


import com.example.school.dto.requestdto.StudentRequestDto;

import com.example.school.dto.responsedto.ApiResponse;
import com.example.school.dto.responsedto.StudentResponseDto;
import com.example.school.service.StudentService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @PostMapping
    public ApiResponse<StudentResponseDto> addStudent(@RequestBody StudentRequestDto dto) {
        return studentService.addStudent(dto);
    }

    @PutMapping("/{id}")
    public ApiResponse<StudentResponseDto> updateStudent(@PathVariable Long id,
                                                         @RequestBody StudentRequestDto dto) {
        return studentService.updateStudent(id, dto);
    }

    @GetMapping("/{id}")
    public ApiResponse<StudentResponseDto> getStudent(@PathVariable Long id) {
        return studentService.getStudentById(id);
    }

    @GetMapping
    public ApiResponse<List<StudentResponseDto>> getAllStudents() {
        return studentService.getAllStudents();
    }

    @DeleteMapping("/{id}")
    public ApiResponse<String> deleteStudent(@PathVariable Long id) {
        return studentService.deleteStudent(id);
    }
}
