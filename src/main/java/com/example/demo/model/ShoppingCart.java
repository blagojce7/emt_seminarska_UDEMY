package com.example.demo.model;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
public class ShoppingCart {
    @Id
    private Long id;
    private Date date;
    @ManyToMany
    private List<Courses> courses;

    @OneToOne
    private Person person;

    public ShoppingCart(Long id, Date date, List<Courses> courses, Person person) {
        this.id = id;
        this.date = date;
        this.courses = courses;
        this.person = person;
    }

    public ShoppingCart() {

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public List<Courses> getCourses() {
        return courses;
    }

    public void setCourses(List<Courses> courses) {
        this.courses = courses;
    }

    public Person getPerson() {
        return person;
    }

    public void setPerson(Person person) {
        this.person = person;
    }
}
