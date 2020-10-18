package com.example.demo.service.impl;

import com.example.demo.model.Instructor;
import com.example.demo.service.InstructorService;
import org.springframework.stereotype.Service;

import java.io.IOException;
import java.util.List;
@Service
public class InstructorServiceImpl implements InstructorService {
    @Override
    public List<Instructor> findAll() {
        return null;
    }

    @Override
    public List<Instructor> findTopInstructor() {
        return null;
    }

    @Override
    public Instructor findInstructorById(Long id) {
        return null;
    }

    @Override
    public Instructor saveInstructor(Instructor instructor) throws IOException {
        return null;
    }

    @Override
    public Instructor updateInstructor(Instructor instructor) throws IOException {
        return null;
    }

    @Override
    public void deleteInstructor(Long id) {

    }
}
