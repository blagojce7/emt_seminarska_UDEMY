package com.example.demo.service;

import com.example.demo.model.Category;
import com.example.demo.model.Courses;
import com.example.demo.model.Instructor;
import com.example.demo.model.ShoppingCart;

import java.io.IOException;
import java.util.List;

public interface CoursesService {
    List<Courses> findAllCourses();
    List<Courses> findTopCourses();
    Courses findCourseByID(Long id);
    List<Courses> findAllByInstructor(Long instructorId);
    List<Courses> findAllByCategory(Long categoryId);
    Courses saveCourse(Courses course) throws IOException;
    Courses updateCourse(Long id,Courses courses) throws IOException;
    void deleteCourse(Long id);
    public Courses save(Courses course);
    Courses saveNaBaceNachin(Long id,String name, String description, String image, Long price, Long category, Long instructor);

   // Courses saveNaBaceNachin(String name, String description, String image, Long price, Category category, Instructor instructor, ShoppingCart shoppingCart);
}
