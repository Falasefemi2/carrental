package com.project.user;

import java.util.List;

import com.project.car.CarServices;

public class UserService implements IUser {
    private final User user;
    private final CarServices carServices;

    public UserService(User user, CarServices carServices) {
        this.user = user;
        this.carServices = carServices;
    }

    @Override
    public List<String> viewHistory() {
        return user.getRentalHistory();
    }

    @Override
    public void rentCar(String carId) {
        carServices.rentCarToUser(carId, user);
    }

    @Override
    public void returnCar(String carId) {
        carServices.returnCarFromUser(carId, user);
    }

}
