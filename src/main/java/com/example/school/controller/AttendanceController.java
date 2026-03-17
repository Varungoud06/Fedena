package com.example.school.controller;

import com.example.school.dto.requestdto.AttendanceRequestDTO;
import com.example.school.dto.responsedto.AttendanceResponseDTO;
import com.example.school.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/attendance")
@RequiredArgsConstructor
public class AttendanceController {

    private final AttendanceService attendanceService;

    @PostMapping
    public AttendanceResponseDTO createAttendance(@RequestBody AttendanceRequestDTO dto) {
        return attendanceService.createAttendance(dto);
    }

    @GetMapping
    public List<AttendanceResponseDTO> getAllAttendance() {
        return attendanceService.getAllAttendance();
    }

    @GetMapping("/{id}")
    public AttendanceResponseDTO getAttendanceById(@PathVariable Long id) {
        return attendanceService.getAttendanceById(id);
    }

    @PutMapping("/{id}")
    public AttendanceResponseDTO updateAttendance(@PathVariable Long id,
                                                  @RequestBody AttendanceRequestDTO dto) {
        return attendanceService.updateAttendance(id, dto);
    }

    @DeleteMapping("/{id}")
    public String deleteAttendance(@PathVariable Long id) {

        attendanceService.deleteAttendance(id);

        return "Attendance deleted successfully";
    }
}