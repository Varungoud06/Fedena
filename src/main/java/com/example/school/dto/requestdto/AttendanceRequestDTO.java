package com.example.school.dto.requestdto;

import com.example.school.constants.AttendanceStatus;
import lombok.Data;

import java.time.LocalDate;

@Data
public class AttendanceRequestDTO {

    private Long studentId;

    private Long teacherId;

    private Long classId;

    private Long subjectId;

    private LocalDate attendanceDate;

    private AttendanceStatus status;

}