package com.develhope.bookstore.entities;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name = "orders")
public class Orders {
    // parameters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Double totalCost;
    private boolean isActive = true;
    // relations
    @ManyToOne
    @JoinColumn(name = "id_client")
    private Client client;
    @OneToMany(mappedBy = "orders")
    private List<BookCopies> bookCopies;
    @ManyToMany
    @JoinTable(
           name = "author_orders",
           joinColumns = @JoinColumn(name = "id_author"),
           inverseJoinColumns = @JoinColumn(name = "id_order")
    )
    private List<Author> author;

    // empty constructo
    public Orders(){}
    // constructor with all the parameters

    public Orders(Double totalCost, boolean isActive, Client client, List<BookCopies> bookCopies, List<Author> author) {
        this.totalCost = totalCost;
        this.isActive = isActive;
        this.client = client;
        this.bookCopies = bookCopies;
        this.author = author;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public Double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(Double totalCost) {
        this.totalCost = totalCost;
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

    public List<BookCopies> getBookCopies() {
        return bookCopies;
    }

    public void setBookCopies(List<BookCopies> bookCopiesCatalogue) {
        this.bookCopies = bookCopiesCatalogue;
    }

    public List<Author> getAuthor() {
        return author;
    }

    public void setAuthor(List<Author> author) {
        this.author = author;
    }
}
