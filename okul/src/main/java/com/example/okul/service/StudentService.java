package com.example.okul.service;

import com.example.okul.model.Grade;
import com.example.okul.model.Student;
import com.example.okul.repository.StudentRepository;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.concurrent.CompletableFuture;
import java.util.stream.Collectors;

@Service
public class StudentService {

    private final StudentRepository studentRepository;

    public StudentService(StudentRepository studentRepository) {
        this.studentRepository = studentRepository;
    }

    public List<Student> getAll() {
        return studentRepository.findAll();
    }

    public Student save(Student student) {
        return studentRepository.save(student);
    }

    // Stream + Lambda: En iyi öğrenciyi bul
    public Optional<Student> getTopStudent(List<Grade> allGrades) {
        return allGrades.stream()
                .collect(Collectors.groupingBy(
                        Grade::getStudent,
                        Collectors.averagingDouble(Grade::getScore)
                ))
                .entrySet().stream()
                .max(Map.Entry.comparingByValue())
                .map(Map.Entry::getKey);
    }

    // Sıralama: ortalamaya göre sırala
    public List<Student> getStudentsSortedByAverage(List<Grade> allGrades) {
        Map<Student, Double> avgMap = allGrades.stream()
                .collect(Collectors.groupingBy(
                        Grade::getStudent,
                        Collectors.averagingDouble(Grade::getScore)
                ));

        return avgMap.entrySet().stream()
                .sorted(Map.Entry.<Student, Double>comparingByValue().reversed())
                .map(Map.Entry::getKey)
                .collect(Collectors.toList());
    }

    // Multithread: asenkron listeleme
    public CompletableFuture<List<Student>> getAllAsync() {
        return CompletableFuture.supplyAsync(() -> studentRepository.findAll());
    }
}

