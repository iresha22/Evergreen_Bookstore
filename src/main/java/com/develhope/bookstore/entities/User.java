package com.develhope.bookstore.entities;

import jakarta.persistence.*;

@MappedSuperclass
public class User {
    // parameters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Integer age;
    private String address;
    @Column(name = "is_active")
    private boolean isActive = true;
    @Column(unique = true)
    private String email;
    private String password;

    // constructor without the parameters
    public User(){}

    // constructor with all the parameters
    public User(Long id, String name, Integer age, String address, boolean isActive, String email, String password) {
        this.id = id;
        this.name = name;
        this.age = age;
        this.address = address;
        this.isActive = isActive;
        this.email = email;
        this.password = password;
    }

    // getters and setters

    public Long getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
