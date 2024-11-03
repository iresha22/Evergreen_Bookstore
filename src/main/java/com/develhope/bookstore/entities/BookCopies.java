package com.develhope.bookstore.entities;

import jakarta.persistence.*;

@Entity
@Table(name = "book_copies")
public class BookCopies {
    // parameters
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO )
    private Long id;
    private boolean isActive = true;
    // relations
    @ManyToOne
    @JoinColumn(name = "id_book")
    private Book book;
    @ManyToOne
    @JoinColumn(name = "id_order")
    private Orders orders;

    // empty constructor
    public BookCopies(){}

    // constructor with all the parameters
    public BookCopies(Long id, Book book, Orders orders, boolean isActive) {
        this.id = id;
        this.book = book;
        this.orders = orders;
        this.isActive=isActive;
    }

    // getters and setters
    public Long getId() {
        return id;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Orders getOrders() {return orders;}

    public void setOrders(Orders order) {
        this.orders = order;
    }

    public boolean isActive() {return isActive;}

    public void setActive(boolean active) {isActive = active;}
}
