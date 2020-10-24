package com.example.demo.service.impl;

import com.example.demo.model.Courses;
import com.example.demo.model.Person;
import com.example.demo.model.exceptions.UserAlreadyExistsException;
import com.example.demo.model.exceptions.UserNotFoundException;
import com.example.demo.repository.PersonRepository;
import com.example.demo.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class PersonServiceImpl implements PersonService {
    @Autowired
    PersonRepository personRepository;

    @Override
    public Person findById(Long id) {
        return this.personRepository.findById(id).orElseThrow(() -> new UserNotFoundException(id));
    }

    @Override
    public Person registerPerson(Person person) {

        return this.personRepository.save(person);

    }

}
