package com.project.car;

import com.project.user.User;

public interface ICar {
    void addCar(Car car);

    Car findCarById(String id);

    void markCarRented(String id);

    void markCarReturned(String id);

    void rentCarToUser(String carId, User user);

    void returnCarFromUser(String carId, User user);

}
