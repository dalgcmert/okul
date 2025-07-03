package com.example.okul.service;

import com.example.okul.model.Grade;
import com.example.okul.repository.GradeRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GradeService {

    private final GradeRepository gradeRepository;

    public GradeService(GradeRepository gradeRepository) {
        this.gradeRepository = gradeRepository;
    }

    public Grade save(Grade grade) {
        return gradeRepository.save(grade);
    }

    public List<Grade> getByStudentId(Long studentId) {
        return gradeRepository.findByStudentId(studentId);
    }

    // ✅ Eksik olan metod
    public List<Grade> getAll() {
        return gradeRepository.findAll();
    }
}
