package com.develhope.bookstore.entities;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

import java.time.LocalDate;
import java.util.List;

@Entity
@Table(name = "client")
public class Client extends User{
    // parameters
    // the user is able to leave a review and receive a review
    private String review;
    // relations
    // client can make orders and receive orders
    @OneToMany(mappedBy = "client")
    private List<Orders> orderCatalogue;
    @OneToMany(mappedBy = "client")
    private List<UsedBooks> usedBooks;
    // add payment card list
    private List<String> paymentCards;

    // empty constructor
    public Client(){}

    // constructor with all the parameters


    public Client(Long id, String name, Integer age, String address, boolean isActive, String email, String password,
                  String review, List<Orders> orderCatalogue, List<UsedBooks> usedBooks,List<String> paymentCards) {
        super(id, name, age, address, isActive, email, password);
        this.review = review;
        this.orderCatalogue = orderCatalogue;
        this.usedBooks = usedBooks;
        this.paymentCards = paymentCards;
    }

    // getters and setters

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public List<Orders> getOrderCatalogue() {
        return orderCatalogue;
    }

    public void setOrderCatalogue(List<Orders> orderCatalogue) {
        this.orderCatalogue = orderCatalogue;
    }

    public List<UsedBooks> getUsedBooks() {
        return usedBooks;
    }

    public void setUsedBooks(List<UsedBooks> usedBooks) {
        this.usedBooks = usedBooks;
    }

    public List<String> getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(List<String> paymentCards) {
        this.paymentCards = paymentCards;
    }
}
