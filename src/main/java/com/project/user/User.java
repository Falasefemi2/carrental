package com.project.user;

import java.util.List;

public class User {
    private String id;
    private String name;
    private List<String> rentalHistory;

    public User(String id, String name, List<String> rentalHistory) {
        this.id = id;
        this.name = name;
        this.rentalHistory = rentalHistory;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<String> getRentalHistory() {
        return rentalHistory;
    }

    public void setRentalHistory(List<String> rentalHistory) {
        this.rentalHistory = rentalHistory;
    }

    public void addRental(String carId) {
        this.rentalHistory.add(carId);
    }

    @Override
    public String toString() {
        return "ID: " + id + ", Name: " + name + ", Rentals: " + rentalHistory;
    }

}
