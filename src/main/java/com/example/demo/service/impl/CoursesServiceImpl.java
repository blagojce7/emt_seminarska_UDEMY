package com.example.demo.service.impl;

import com.example.demo.model.Courses;
import com.example.demo.model.Instructor;
import com.example.demo.model.exceptions.CourseNotFound;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Optional;

@Service
public class CoursesServiceImpl implements CoursesService {
    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    InstructorRepository instructorRepository;

    @Autowired
    CategoryRepository categoryRepository;

    @Override
    public List<Courses> findAllCourses() {
        return this.coursesRepository.findAll();
    }

    @Override
    public List<Courses> findTopCourses() {
        return null;
    }

    @Override
    public Courses findCourseByID(Long id) {
        return this.coursesRepository.findById(id).orElseThrow(() -> new CourseNotFound(id));
    }

    @Override
    public List<Courses> findAllByInstructor(Long instructorId) {
        List<Courses> coursesList = null;
        List<Instructor> instructorList = this.instructorRepository.findAll();
        for(Instructor i : instructorList){
            if(i.getId().equals(instructorId)){
                coursesList=i.getCourses();
                break;
            }
        }
        return coursesList;
    }

    @Override
    public List<Courses> findAllByCategory(Long categoryId) {
        return null;
    }

    @Override
    public Courses saveCourse(Courses course, Long instructorId, Long categoryId) throws IOException {
        Courses newCourse =  new Courses();
        newCourse.setId(course.getId());
        newCourse.setDescription(course.getDescription());
        newCourse.setImage(course.getImage());
        newCourse.setName(course.getName());
        newCourse.setPrice(course.getPrice());
        newCourse.setInstructor(instructorRepository.findById(instructorId));
        newCourse.setCategory(categoryRepository.findById(categoryId));


        return this.coursesRepository.save(newCourse);
    }



    @Override
    public Courses updateCourse(Long id, Courses courses) throws IOException {
        return null;
    }

    @Override
    public void deleteCourse(Long id) {

    }
}
