package com.example.demo.service.impl;

import com.example.demo.model.Courses;
import com.example.demo.model.Person;
import com.example.demo.model.ShoppingCart;
import com.example.demo.repository.CoursesRepository;
import com.example.demo.repository.PersonRepository;
import com.example.demo.repository.ShoppingCartRepository;
import com.example.demo.service.ShoppingCartService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ShoppingCartServiceImpl implements ShoppingCartService {
    @Autowired
    ShoppingCartRepository shoppingCartRepository;

    @Autowired
    CoursesRepository coursesRepository;

    @Autowired
    PersonRepository personRepository;

    @Override
    public ShoppingCart addCourseToShoppingCart(Long userId, Long CourseID) {
        Person person = this.personRepository.findById(userId).orElseThrow(() -> new RuntimeException());
        Courses course = this.coursesRepository.findById(CourseID).orElseThrow(() -> new RuntimeException());
        ShoppingCart shoppingCart = person.getShoppingCart();
        shoppingCart.getCourses().add(course);
        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public ShoppingCart removeCourseFromShoppingCart(Long userId, Long productId) {
        Person person = this.personRepository.findById(userId).orElseThrow(); //da se dodadat exceptions
        ShoppingCart shoppingCart = person.getShoppingCart();
        shoppingCart.setCourses(
                shoppingCart.getCourses()
                    .stream()
                .filter(courses -> !courses.getId().equals(productId))
                .collect(Collectors.toList())
        );

        return this.shoppingCartRepository.save(shoppingCart);
    }

    @Override
    public List<ShoppingCart> findAllShoppingCarts() {
        return this.shoppingCartRepository.findAll();
    }
}
