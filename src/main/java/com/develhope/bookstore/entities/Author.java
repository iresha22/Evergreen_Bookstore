package com.develhope.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "author")
public class Author extends User{
    // parameters
    private String description;
    // relations
    @OneToMany(mappedBy = "author")
    private List<Book> bookCatalogue;
    @ManyToMany(mappedBy = "author")
    private List<Orders> orders;

    // constructor without parameters
    public Author(){}

    // constructor with all the parameters
    public Author(Long id, String name, boolean isActive, String email, String password, String description, List<Book> bookCatalogue, List<Orders> orders) {
        super(id, name, isActive, email, password);
        this.description = description;
        this.bookCatalogue = bookCatalogue;
        this.orders = orders;
    }

    // getters and setters

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<Book> getBookCatalogue() {
        return bookCatalogue;
    }

    public void setBookCatalogue(List<Book> bookCatalogue) {
        this.bookCatalogue = bookCatalogue;
    }

    public List<Orders> getOrders() {
        return orders;
    }

    public void setOrders(List<Orders> orders) {
        this.orders = orders;
    }
}
