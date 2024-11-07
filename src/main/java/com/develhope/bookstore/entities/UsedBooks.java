package com.develhope.bookstore.entities;

import com.develhope.bookstore.enums.Genre;
import jakarta.persistence.*;

@Entity
@Table(name = "used_books")
public class UsedBooks {
    // parameters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    private String author;
    private Genre genre;
    private String description;
    //enum of condition
    private String condition;
    private Boolean available = true;
    @Column(name = "is_active")
    private boolean isActive = true;
    // relations
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders orders;

    // constructor without the parameters
    public UsedBooks(){}

    // constructor with parameters
    public UsedBooks(Long id, String name, String author, Genre genre, String description, String condition, Boolean available,
                     boolean isActive, Client client, Orders orders) {
        this.id = id;
        this.name = name;
        this.author = author;
        this.genre = genre;
        this.description = description;
        this.condition = condition;
        this.available = available;
        this.isActive = isActive;
        this.client = client;
        this.orders = orders;
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

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
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

    public String getCondition() {
        return condition;
    }

    public void setCondition(String condition) {
        this.condition = condition;
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

    public Client getClient() {
        return client;
    }

    public void setClient(Client client) {
        this.client = client;
    }

    public Orders getOrders() {
        return orders;
    }

    public void setOrders(Orders orders) {
        this.orders = orders;
    }
}
