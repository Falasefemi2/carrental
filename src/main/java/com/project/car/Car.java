package com.project.car;

public class Car {
    private String id;
    private String brand;
    private String model;
    private int year;
    private int rentalPricePerDay;
    private boolean availabilityStatus;

    public Car(String id, String brand, String model, int year, int rentalPricePerDay) {
        this.id = id;
        this.brand = brand;
        this.model = model;
        this.year = year;
        this.rentalPricePerDay = rentalPricePerDay;
        this.availabilityStatus = true;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public int getRentalPricePerDay() {
        return rentalPricePerDay;
    }

    public void setRentalPricePerDay(int rentalPricePerDay) {
        this.rentalPricePerDay = rentalPricePerDay;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    @Override
    public String toString() {
        return "ID: " + id +
                ", Brand: " + brand +
                ", Model: " + model +
                ", Year: " + year +
                ", Rental Price/Day: ₦" + rentalPricePerDay +
                ", Availability: " + (availabilityStatus ? "Yes" : "No");
    }

}
