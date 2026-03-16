package com.example.school.dto.requestdto;



import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class StudentRequestDto {

    @NotBlank(message = "Student name is required")
    private String name;

    @NotBlank(message = "Roll number is required")
    private String rollNumber;

    @NotBlank(message = "Email is required")
    @Email(message = "Enter valid email")
    private String email;

    @NotBlank(message = "Phone is required")
    private String phone;
}
