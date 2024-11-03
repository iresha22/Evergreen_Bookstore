package com.develhope.bookstore.entities;

import com.develhope.bookstore.enums.Genre;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "book")
public class Book {
    // parameters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private Boolean available = true;
    private boolean isActive = true;
    private Genre genre;
    private String description;
    // relations
    @OneToMany(mappedBy = "book")
    private List<BookCopies> bookCopies;
    @ManyToOne
    @JoinColumn(name = "id_author")
    private Author author;

    // constructor without the parameters
    public Book(){}

    // constructor with parameters
    public Book(Long id, String name, Boolean available,boolean isActive, Genre genre, String description, List<BookCopies> bookCopies, Author author) {
        this.id = id;
        this.name = name;
        this.available = available;
        this.isActive = isActive;
        this.genre = genre;
        this.description = description;
        this.bookCopies = bookCopies;
        this.author = author;
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

    public Boolean getAvailable() {
        return available;
    }

    public void setAvailable(Boolean available) {
        this.available = available;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setActive(boolean active) {
        isActive = active;
    }

    public Genre getGenre() {
        return genre;
    }

    public void setGenre(Genre genre) {
        this.genre = genre;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public List<BookCopies> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopies> bookCopies) {
        this.bookCopies = bookCopies;
    }

    public Author getAuthor() {
        return author;
    }

    public void setAuthor(Author author) {
        this.author = author;
    }
}
