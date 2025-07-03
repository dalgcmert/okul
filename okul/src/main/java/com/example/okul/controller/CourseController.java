package com.example.okul.controller;

import com.example.okul.model.Course;
import com.example.okul.service.CourseService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/courses")
public class CourseController {

    private final CourseService courseService;

    public CourseController(CourseService courseService) {
        this.courseService = courseService;
    }

    @GetMapping
    public List<Course> getAll() {
        return courseService.getAll();
    }

    @PostMapping
    public Course save(@RequestBody Course course) {
        return courseService.save(course);
    }
}
