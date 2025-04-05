package com.project.car;

import java.util.ArrayList;
import java.util.List;

import com.project.user.User;

public class CarServices implements ICar {
    private final List<Car> cars = new ArrayList<>();

    @Override
    public void addCar(Car car) {
        cars.add(car);
        System.out.println("Car added successfully");
    }

    @Override
    public Car findCarById(String id) {
        for (Car car : cars) {
            if (car.getId().equals(id)) {
                return car;
            }
        }
        return null;
    }

    @Override
    public void rentCarToUser(String carId, User user) {
        Car car = findCarById(carId);
        if (car != null && car.isAvailabilityStatus()) {
            car.setAvailabilityStatus(false);
            user.addRental(carId); // add to user's rental history
            System.out.println("Car " + carId + " rented to " + user.getName());
        } else {
            System.out.println("Car not available for rent.");
        }
    }

    @Override
    public void returnCarFromUser(String carId, User user) {
        Car car = findCarById(carId);
        if (car != null && !car.isAvailabilityStatus()) {
            car.setAvailabilityStatus(true);
            System.out.println("Car " + carId + " returned by " + user.getName());
        } else {
            System.out.println("Car is already available or does not exist.");
        }
    }

    @Override
    public void markCarRented(String id) {
        Car car = findCarById(id);
        if (car != null && car.isAvailabilityStatus()) {
            car.setAvailabilityStatus(false);
            System.out.println("Car with ID " + id + " has been rented.");
        } else {
            System.out.println("Car does not exist");
        }
    }

    @Override
    public void markCarReturned(String id) {
        Car car = findCarById(id);
        if (car != null && !car.isAvailabilityStatus()) {
            car.setAvailabilityStatus(true);
            System.out.println("Car with ID " + id + " has been returned.");
        } else {
            System.out.println("Car not rented or does not exist.");
        }
    }
}
