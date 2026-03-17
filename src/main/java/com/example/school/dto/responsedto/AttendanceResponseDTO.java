package com.example.school.dto.responsedto;

import com.example.school.constants.AttendanceStatus;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;

@Data
@Builder
public class AttendanceResponseDTO {

    private Long id;

    private Long studentId;

    private Long teacherId;

    private Long classId;

    private Long subjectId;

    private LocalDate attendanceDate;

    private AttendanceStatus status;

}