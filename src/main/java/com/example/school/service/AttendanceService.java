package com.example.school.service;

import com.example.school.dto.requestdto.AttendanceRequestDTO;
import com.example.school.dto.responsedto.AttendanceResponseDTO;

import java.util.List;

public interface AttendanceService {

    AttendanceResponseDTO createAttendance(AttendanceRequestDTO requestDTO);

    List<AttendanceResponseDTO> getAllAttendance();

    AttendanceResponseDTO getAttendanceById(Long id);

    AttendanceResponseDTO updateAttendance(Long id, AttendanceRequestDTO requestDTO);

    void deleteAttendance(Long id);

}