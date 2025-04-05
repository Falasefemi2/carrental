package com.project;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import com.project.admin.Admin;
import com.project.car.Car;
import com.project.car.CarServices;
import com.project.user.User;
import com.project.user.UserService;

public class Main {
    private static final CarServices carServices = new CarServices();
    private static Admin admin;
    private static User currentUser;
    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        initSystem();

        while (true) {
            System.out.println("\n==== Car Rental System ====");
            System.out.println("1. Login as Admin");
            System.out.println("2. Login as User");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    adminMenu();
                }
                case 2 -> {
                    userLogin();
                }
                case 3 -> {
                    try (scanner) {
                        System.out.println("Thank you for using the Car Rental System. Goodbye!");
                    }
                    return;
                }

                default -> System.out.println("Invalid choice");
            }
        }
    }

    private static void initSystem() {
        admin = new Admin("A001", "Admin", new ArrayList<>(), "ADMIN0001", carServices, null);

        carServices.addCar(new Car("C001", "Toyota", "Corolla", 2020, 5));
        carServices.addCar(new Car("C002", "Honda", "Civic", 2021, 5));
        System.out.println("System initialized with admin and sample cars.");
    }

    private static void adminMenu() {
        boolean adminLoggedIn = true;

        while (adminLoggedIn) {
            System.out.println("\n==== Admin Menu ====");
            System.out.println("1. Add New Car");
            System.out.println("2. Add New User");
            System.out.println("3. Mark Car as Rented");
            System.out.println("4. Mark Car as Returned");
            System.out.println("5. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Car ID: ");
                    String carId = scanner.nextLine();
                    System.out.print("Enter Car Make: ");
                    String make = scanner.nextLine();
                    System.out.print("Enter Car Model: ");
                    String model = scanner.nextLine();
                    System.out.print("Enter Car Year: ");
                    int year = scanner.nextInt();
                    System.out.print("Enter Car Capacity: ");
                    int capacity = scanner.nextInt();
                    scanner.nextLine();

                    admin.addCar(carId, make, model, year, capacity);
                }
                case 2 -> {
                    System.out.print("Enter User ID: ");
                    String userId = scanner.nextLine();
                    System.out.print("Enter User Name: ");
                    String userName = scanner.nextLine();

                    admin.addUser(userId, userName);
                }
                case 3 -> {
                    System.out.print("Enter Car ID to mark as rented: ");
                    String rentedCarId = scanner.nextLine();

                    admin.markCarRented(rentedCarId);
                }
                case 4 -> {
                    System.out.print("Enter Car ID to mark as returned: ");
                    String returnedCarId = scanner.nextLine();

                    admin.markCarReturned(returnedCarId);
                }
                case 5 -> {
                    adminLoggedIn = false;
                    System.out.println("Admin logged out successfully.");
                }
                default -> System.out.println("Invalid option");
            }

        }
    }

    public static void userLogin() {
        System.out.print("Enter User ID: ");
        String userId = scanner.nextLine();

        currentUser = new User(userId, "Sample User", new ArrayList<>());
        UserService userService = new UserService(currentUser, carServices);

        userMenu(userService);
    }

    public static void userMenu(UserService userService) {
        boolean userLoggedIn = true;

        while (userLoggedIn) {
            System.out.println("\n==== User Menu ====");
            System.out.println("1. Rent a Car");
            System.out.println("2. Return a Car");
            System.out.println("3. View Rental History");
            System.out.println("4. Logout");
            System.out.print("Enter your choice: ");

            int choice = scanner.nextInt();
            scanner.nextLine();

            switch (choice) {
                case 1 -> {
                    System.out.print("Enter Car ID to rent: ");
                    String rentCarId = scanner.nextLine();

                    userService.rentCar(rentCarId);
                }
                case 2 -> {
                    System.out.print("Enter Car ID to return: ");
                    String returnCarId = scanner.nextLine();

                    userService.returnCar(returnCarId);
                }
                case 3 -> {
                    System.out.println("Your Rental History:");
                    List<String> history = userService.viewHistory();

                    if (history.isEmpty()) {
                        System.out.println("No rental history found.");
                    } else {
                        for (String rentalId : history) {
                            System.out.println("- Car ID: " + rentalId);
                        }
                    }
                }
                case 4 -> {
                    userLoggedIn = false;
                    System.out.println("User logged out successfully.");
                }
                default -> System.out.println("Invalid options");
            }
        }
    }
}