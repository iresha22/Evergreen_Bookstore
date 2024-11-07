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
    private List<UsedBooks> usedBooks;

    // empty constructor
    public Orders(){}
    // constructor with all the parameters


    public Orders(Long id, Double totalCost, boolean isActive, Client client, List<UsedBooks> usedBooks) {
        this.id = id;
        this.totalCost = totalCost;
        this.isActive = isActive;
        this.client = client;
        this.usedBooks = usedBooks;
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

    public List<UsedBooks> getUsedBooks() {
        return usedBooks;
    }

    public void setUsedBooks(List<UsedBooks> usedBooks) {
        this.usedBooks = usedBooks;
    }
}
