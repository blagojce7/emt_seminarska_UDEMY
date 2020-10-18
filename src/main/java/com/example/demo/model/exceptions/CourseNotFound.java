package com.example.demo.model.exceptions;

public class CourseNotFound extends RuntimeException {
    public CourseNotFound(Long id) {
        super(String.format("Course not found %s",id));
    }
}
