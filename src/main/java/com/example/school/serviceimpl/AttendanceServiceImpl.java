package com.example.school.serviceimpl;

import com.example.school.dto.requestdto.AttendanceRequestDTO;
import com.example.school.dto.responsedto.AttendanceResponseDTO;
import com.example.school.entity.Attendance;
import com.example.school.repo.AttendanceRepository;
import com.example.school.service.AttendanceService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AttendanceServiceImpl implements AttendanceService {

    private final AttendanceRepository attendanceRepository;

    @Override
    public AttendanceResponseDTO createAttendance(AttendanceRequestDTO dto) {

        Attendance attendance = Attendance.builder()
                .studentId(dto.getStudentId())
                .teacherId(dto.getTeacherId())
                .classId(dto.getClassId())
                .subjectId(dto.getSubjectId())
                .attendanceDate(dto.getAttendanceDate())
                .status(dto.getStatus())
                .build();

        Attendance saved = attendanceRepository.save(attendance);

        return mapToResponse(saved);
    }

    @Override
    public List<AttendanceResponseDTO> getAllAttendance() {

        return attendanceRepository.findAll()
                .stream()
                .map(this::mapToResponse)
                .collect(Collectors.toList());
    }

    @Override
    public AttendanceResponseDTO getAttendanceById(Long id) {

        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        return mapToResponse(attendance);
    }

    @Override
    public AttendanceResponseDTO updateAttendance(Long id, AttendanceRequestDTO dto) {

        Attendance attendance = attendanceRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("Attendance not found"));

        attendance.setStudentId(dto.getStudentId());
        attendance.setTeacherId(dto.getTeacherId());
        attendance.setClassId(dto.getClassId());
        attendance.setSubjectId(dto.getSubjectId());
        attendance.setAttendanceDate(dto.getAttendanceDate());
        attendance.setStatus(dto.getStatus());

        Attendance updated = attendanceRepository.save(attendance);

        return mapToResponse(updated);
    }

    @Override
    public void deleteAttendance(Long id) {

        attendanceRepository.deleteById(id);
    }

    private AttendanceResponseDTO mapToResponse(Attendance attendance) {

        return AttendanceResponseDTO.builder()
                .id(attendance.getId())
                .studentId(attendance.getStudentId())
                .teacherId(attendance.getTeacherId())
                .classId(attendance.getClassId())
                .subjectId(attendance.getSubjectId())
                .attendanceDate(attendance.getAttendanceDate())
                .status(attendance.getStatus())
                .build();
    }
}