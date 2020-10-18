package com.example.demo.web.restControllers;

import com.example.demo.model.Courses;
import com.example.demo.service.CoursesService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.concurrent.CountDownLatch;

@RestController
@RequestMapping("/api/courses")
public class CoursesController {

    private final CoursesService coursesService;

    public CoursesController(CoursesService coursesService) {
        this.coursesService = coursesService;
    }
    @GetMapping
    public List<Courses> findAll(){
        return this.coursesService.findAllCourses();
    }

    @GetMapping("/{id}")
    public Courses findCourseById(@PathVariable Long id){
        return this.coursesService.findCourseByID(id);
    }

}
