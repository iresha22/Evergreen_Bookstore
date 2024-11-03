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
    private String address;
    private String review;
    private LocalDate birthdate;
    // relations
    @OneToMany(mappedBy = "client")
    private List<Orders> orderCatalogue;
    // add paymentcard list
    private List<String> paymentCards;

    // empty constructor
    public Client(){}

    // constructor with all the parameters
    public Client(Long id, String name, boolean isActive, String email, String password, String address, String review,
                  LocalDate birthdate, List<Orders> orderCatalogue, List<String> paymentCards) {
        super(id, name, isActive, email, password);
        this.address = address;
        this.review = review;
        this.birthdate = birthdate;
        this.orderCatalogue = orderCatalogue;
        this.paymentCards = paymentCards;
    }


    // getters and setters
    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getReview() {
        return review;
    }

    public void setReview(String review) {
        this.review = review;
    }

    public LocalDate getBirthdate() {
        return birthdate;
    }

    public void setBirthdate(LocalDate birthdate) {
        this.birthdate = birthdate;
    }

    public List<Orders> getOrderCatalogue() {
        return orderCatalogue;
    }

    public void setOrderCatalogue(List<Orders> orderCatalogue) {
        this.orderCatalogue = orderCatalogue;
    }

    public List<String> getPaymentCards() {
        return paymentCards;
    }

    public void setPaymentCards(List<String> paymentCards) {
        this.paymentCards = paymentCards;
    }
}
