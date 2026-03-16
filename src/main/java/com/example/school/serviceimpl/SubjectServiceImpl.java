package com.example.school.serviceimpl;

import com.example.school.dto.requestdto.SubjectRequestDTO;
import com.example.school.dto.responsedto.SubjectResponseDTO;
import com.example.school.entity.Subject;
import com.example.school.repo.SubjectRepository;
import com.example.school.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
public class SubjectServiceImpl implements SubjectService {

    private final SubjectRepository repo;

    @Override
    public SubjectResponseDTO createSubject(SubjectRequestDTO request) {
        Subject subject = mapToEntity(request);
        Subject saved=repo.save(subject);
        return mapToResponse(saved);
    }

    @Override
    public List<SubjectResponseDTO> getAllSubjects() {
        List<Subject> subjects = repo.findAll();
        return subjects.stream().map(this::mapToResponse).toList();
    }

    @Override
    public List<SubjectResponseDTO> getAllActiveSubjects() {
        List<Subject> subjects = repo.findByDeletedFalse();
        return subjects.stream().map(this::mapToResponse).toList();
    }

    @Override
    public SubjectResponseDTO getSubjectById(Long id) {
        Subject subject = repo.findByIdAndDeletedFalse(id)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        return mapToResponse(subject);
    }

    @Override
    public SubjectResponseDTO getSubjectByName(String name) {
        Subject subject = repo.findBySubjectNameAndDeletedFalse(name)
                .orElseThrow(() -> new RuntimeException("Subject not found"));

        return mapToResponse(subject);
    }

    @Override
    @Transactional
    public SubjectResponseDTO updateSubject(Long id, SubjectRequestDTO request) {
        Subject subject = repo.findByIdAndDeletedFalse(id).orElseThrow(()-> new RuntimeException("Id Not Found"));
        subject.setSubjectName(request.getSubjectName());
        Subject updated=repo.save(subject);
        return mapToResponse(updated);
    }

    @Override
    @Transactional
    public void deleteSubject(Long id) {

        Subject subject = repo.findByIdAndDeletedFalse(id).orElseThrow(()-> new RuntimeException("Id Not Found"));
        subject.setDeleted(true);
        repo.save(subject);
    }

    private Subject mapToEntity(SubjectRequestDTO request) {

        return Subject.builder().
                subjectName(request.getSubjectName()).
                build();
    }
    private SubjectResponseDTO mapToResponse(Subject subject) {

        return SubjectResponseDTO.builder().
                id(subject.getId()).
                subjectName(subject.getSubjectName()).
                build();
    }
}
