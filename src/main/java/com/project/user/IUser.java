package com.project.user;

import java.util.List;

public interface IUser {
    void rentCar(String carId);

    void returnCar(String carId);

    List<String> viewHistory();
}
