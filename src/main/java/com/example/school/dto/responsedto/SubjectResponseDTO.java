package com.example.school.dto.responsedto;

import lombok.*;

@Builder
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class SubjectResponseDTO {

    public Long id;
    public String subjectName;
}
