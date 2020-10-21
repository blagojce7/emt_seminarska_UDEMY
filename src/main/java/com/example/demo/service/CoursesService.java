package com.example.demo.service;

import com.example.demo.model.Courses;

import java.io.IOException;
import java.util.List;

public interface CoursesService {
    List<Courses> findAllCourses();
    List<Courses> findTopCourses();
    Courses findCourseByID(Long id);
    List<Courses> findAllByInstructor(Long instructorId);
    List<Courses> findAllByCategory(Long categoryId);
    Courses saveCourse(Courses course,Long instructorId,Long categoryId) throws IOException;
    Courses updateCourse(Long id,Courses courses) throws IOException;
    void deleteCourse(Long id);
    public Courses save(Courses course);
}
