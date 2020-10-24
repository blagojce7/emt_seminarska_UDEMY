package com.example.demo.web.restControllers;

import com.example.demo.model.Courses;
import com.example.demo.model.Person;
import com.example.demo.service.PersonService;
import org.springframework.web.bind.annotation.*;

@CrossOrigin(origins = "http://localhost:3000/")
@RestController
@RequestMapping("/api/person")
public class PersonController {

    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }

    @GetMapping("/{id}")
    public Person findById(@PathVariable Long id){
       return this.personService.findById(id);
    }
    @PostMapping
    public Person registerPerson(@RequestBody Person person){
        return this.personService.registerPerson(person);
    }


}
