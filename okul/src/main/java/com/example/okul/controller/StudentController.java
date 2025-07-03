package com.example.okul.controller;

import com.example.okul.model.ResponseWrapper;
import com.example.okul.model.Student;
import com.example.okul.model.Grade;
import com.example.okul.service.StudentService;
import com.example.okul.service.GradeService;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.concurrent.CompletableFuture;

@RestController
@RequestMapping("/students")
public class StudentController {

    private final StudentService studentService;
    private final GradeService gradeService;

    public StudentController(StudentService studentService, GradeService gradeService) {
        this.studentService = studentService;
        this.gradeService = gradeService;
    }

    @GetMapping
    public List<Student> getAll() {
        return studentService.getAll();
    }

    @PostMapping
    public Student save(@RequestBody Student student) {
        return studentService.save(student);
    }

    // Lambda/Stream: en başarılı öğrenci
    @GetMapping("/top")
    public Student getTopStudent() {
        List<Grade> allGrades = gradeService.getAll();
        return studentService.getTopStudent(allGrades).orElseThrow(() -> new RuntimeException("No students found"));
    }

    // Sıralama: ortalama notlarına göre sırala
    @GetMapping("/sorted")
    public List<Student> getSortedStudents() {
        List<Grade> allGrades = gradeService.getAll();
        return studentService.getStudentsSortedByAverage(allGrades);
    }

    // Generic Wrapper: tüm öğrenciler
    @GetMapping("/allWrapped")
    public ResponseWrapper<List<Student>> getAllWrapped() {
        return new ResponseWrapper<>(studentService.getAll());
    }

    // Multithread: asenkron
    @GetMapping("/async")
    public CompletableFuture<List<Student>> getAllAsync() {
        return studentService.getAllAsync();
    }
}
