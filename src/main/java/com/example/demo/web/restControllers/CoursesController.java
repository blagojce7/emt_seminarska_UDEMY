package com.example.demo.web.restControllers;

import com.example.demo.model.Courses;
import com.example.demo.service.CoursesService;
import org.springframework.web.bind.annotation.*;

import java.io.IOException;
import java.util.List;
import java.util.concurrent.CountDownLatch;
@CrossOrigin(origins = "http://localhost:3000/")
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

    @PostMapping
    public Courses save(@RequestBody Courses course){//Long id,String name, String description, String image, Long price, Long category, Long instructor) {

        return this.coursesService.save(course);
//        return this.coursesService.saveNaBaceNachin(id,name, description, image, price, category, instructor);
    }
    @PutMapping("/{id}")
    public Courses update(@PathVariable Long id, Courses courses) throws IOException {
        return this.coursesService.updateCourse(id, courses);
    }

    @DeleteMapping("/{id}")
    public void delete(@PathVariable Long id){
        this.coursesService.deleteCourse(id);
    }


}
