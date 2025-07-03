package com.example.okul.controller;

import com.example.okul.model.Grade;
import com.example.okul.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/grades")
public class GradeController {

    private final GradeService gradeService;

    public GradeController(GradeService gradeService) {
        this.gradeService = gradeService;
    }

    @PostMapping
    public Grade save(@RequestBody Grade grade) {
        return gradeService.save(grade);
    }

    @GetMapping("/student/{studentId}")
    public List<Grade> getByStudent(@PathVariable Long studentId) {
        return gradeService.getByStudentId(studentId);
    }
}
