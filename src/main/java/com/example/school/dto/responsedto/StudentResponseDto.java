package com.example.school.dto.responsedto;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentResponseDto {

    private Long id;
    private String name;
    private String rollNumber;
    private String email;
    private String phone;
}