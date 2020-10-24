package com.example.demo.service.impl;

import com.example.demo.model.Category;
import com.example.demo.model.Courses;
import com.example.demo.model.Instructor;
import com.example.demo.model.ShoppingCart;
import com.example.demo.model.exceptions.CourseNotFound;
import com.example.demo.repository.CategoryRepository;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.InstructorRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.CoursesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
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
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

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

//    @Override
//    public Courses saveCourse(Courses course, Long instructorId, Long categoryId) throws IOException {
//        Courses newCourse =  new Courses();
//        newCourse.setId(course.getId());
//        newCourse.setDescription(course.getDescription());
//        newCourse.setImage(course.getImage());
//        newCourse.setName(course.getName());
//        newCourse.setPrice(course.getPrice());
//        newCourse.setInstructor(instructorRepository.findById(instructorId).orElseThrow());
//        newCourse.setCategory(categoryRepository.findById(categoryId).orElseThrow());
//
//
//        return this.coursesRepository.save(newCourse);
//    }
    @Override
    public Courses saveCourse(Courses course){//, Long instructorId, Long categoryId) throws IOException {
        Courses newCourse =  new Courses();
        newCourse.setId(course.getId());
        newCourse.setDescription(course.getDescription());
        newCourse.setImage(course.getImage());
        newCourse.setName(course.getName());
        newCourse.setPrice(course.getPrice());
       // newCourse.setInstructor(instructorRepository.findById(instructorId).orElseThrow());
      //  newCourse.setCategory(categoryRepository.findById(categoryId).orElseThrow());


        return this.coursesRepository.save(newCourse);
    }



    @Override
    public Courses updateCourse(Long id, Courses courses) throws IOException {
        Courses newCourse = this.coursesRepository.findById(id).orElseThrow();
        newCourse.setId(courses.getId());
        newCourse.setDescription(courses.getDescription());
        newCourse.setImage(courses.getImage());
        newCourse.setName(courses.getName());
        newCourse.setPrice(courses.getPrice());
        return this.coursesRepository.save(newCourse);

    }

    @Override
    public void deleteCourse(Long id) {
        this.coursesRepository.deleteById(id);
    }

    @Override
    public Courses save(Courses course) {
        return this.coursesRepository.save(course);
    }

    @Override
    public Courses saveNaBaceNachin(Long id,String name, String description, String image, Long price, Long category, Long instructor) {
        Category category1 = this.categoryRepository.findById(category).orElseThrow();
        Instructor instructor1 = this.instructorRepository.findById(instructor).orElseThrow();
       // ShoppingCart shoppingCart1 = this.shoppingCartRepository.findAllById(shoppingCart).orElseThrow();
        Courses newCourse = new Courses(name,description,image,price,category1,instructor1);
        return null;
    }
}
