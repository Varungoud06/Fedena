package com.example.school.service;

import com.example.school.dto.requestdto.SubjectRequestDTO;
import com.example.school.dto.responsedto.SubjectResponseDTO;

import java.util.List;

public interface SubjectService {

    SubjectResponseDTO createSubject(SubjectRequestDTO subject);

    List<SubjectResponseDTO> getAllActiveSubjects();

    SubjectResponseDTO getSubjectById(Long id);

    SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO subject);

    void deleteSubject(Long id);

    List<SubjectResponseDTO> getAllSubjects();

    SubjectResponseDTO getSubjectByName(String name);

}
