package com.example.demo.service;

import com.example.demo.model.Person;

public interface PersonService {
    Person findById(Long id);
    Person registerPerson(Person person);
}
