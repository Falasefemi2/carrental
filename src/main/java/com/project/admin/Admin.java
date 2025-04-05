package com.project.admin;

import java.util.ArrayList;
import java.util.List;

import com.project.car.Car;
import com.project.car.CarServices;
import com.project.user.User;
import com.project.user.UserService;

public class Admin extends User {
    private final CarServices carServices;
    private final UserService userService;
    private final String adminId;
    private final List<User> users = new ArrayList<>();

    public Admin(String id, String name, List<String> rentalHistory, String adminId, CarServices carServices,
            UserService userService) {
        super(id, name, rentalHistory);
        this.adminId = adminId;
        this.carServices = carServices;
        this.userService = userService;
    }

    public void addCar(String id, String make, String model, int year, int capacity) {
        Car car = new Car(id, make, model, year, capacity);
        carServices.addCar(car);
        System.out.println("Admin " + getName() + " added car: " + make + " " + model);
    }

    public void addUser(String id, String name) {
        User user = new User(id, name, new ArrayList<>());
        users.add(user);
        System.out.println("Admin " + getName() + " added user: " + name);
    }

    public void markCarRented(String carId) {
        carServices.markCarRented(carId);
        System.out.println("Admin " + getName() + " marked car " + carId + " as rented");
    }

    public void markCarReturned(String carId) {
        carServices.markCarReturned(carId);
        System.out.println("Admin " + getName() + " marked car " + carId + " as returned");
    }

    public List<User> getAllUsers() {
        return new ArrayList<>(users);
    }

}
