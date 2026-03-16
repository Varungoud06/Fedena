package com.example.school.controller;

import com.example.school.dto.requestdto.SubjectRequestDTO;
import com.example.school.dto.responsedto.SubjectResponseDTO;
import com.example.school.service.SubjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/subject")
@RequiredArgsConstructor
public class SubjectController {

    private final SubjectService subjectService;

    @PostMapping
    public SubjectResponseDTO createSubject(@RequestBody SubjectRequestDTO request){
        return subjectService.createSubject(request);
    }

    @GetMapping
    public List<SubjectResponseDTO> getAllSubjects(){
        return subjectService.getAllSubjects();
    }

    @GetMapping("/active")
    public List<SubjectResponseDTO> getAllActiveSubjects(){
        return subjectService.getAllActiveSubjects();
    }

    @GetMapping("/{id}")
    public SubjectResponseDTO getSubjectById(@PathVariable Long id){
        return subjectService.getSubjectById(id);
    }

    @GetMapping("/name/{name}")
    public SubjectResponseDTO getSubjectByName(@PathVariable String name){
        return subjectService.getSubjectByName(name);
    }

    // Update Subject
    @PutMapping("/{id}")
    public SubjectResponseDTO updateSubject(@PathVariable Long id,
                                            @RequestBody SubjectRequestDTO request){
        return subjectService.updateSubject(id, request);
    }

    @DeleteMapping("/{id}")
    public String deleteSubject(@PathVariable Long id){
        subjectService.deleteSubject(id);
        return "Subject deleted successfully";
    }

}
