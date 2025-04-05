<!-- @format -->

# Car Rental System

The **Car Rental System** is a Java-based application that allows users to rent and return cars, while administrators can manage cars and users. The system provides a simple console-based interface for both administrators and users.

---

## Features

### Admin Features

- Add new cars to the system.
- Add new users to the system.
- Mark cars as rented.
- Mark cars as returned.
- View all users.

### User Features

- Rent a car.
- Return a car.
- View rental history.

---

## Project Structure

The project is organized into modules for better maintainability. Key modules include:

- **Admin Module**: Handles administrative tasks.
- **User Module**: Manages user interactions.
- **Car Module**: Manages car-related operations.

---

## Prerequisites

- **Java**: Version 17 or higher
- **Maven**: Version 3.6 or higher

---

## Setup and Usage

### 1. Clone the Repository

```bash
git clone <repository-url>
cd carrental
```

### 2. Build the Project

Use Maven to compile the project:

```bash
mvn clean install
```

### 3. Run the Application

Execute the `Main` class:

```bash
mvn exec:java -Dexec.mainClass="com.project.Main"
```

---

## Interact with the System

### Admin Workflow

1. Log in as Admin.
2. Add new cars and users.
3. Mark cars as rented or returned.

### User Workflow

1. Log in as a User.
2. Rent a car by providing its ID.
3. Return a car and view rental history.

---

## Dependencies

- **org.json**: Used for JSON handling (planned for future enhancements).

---

## Future Enhancements

- Add a database for persistent storage.
- Implement a graphical user interface (GUI).
- Add authentication for admin and user accounts.
- Enhance error handling and input validation.

---

## License

This project is licensed under the MIT License.

---

## Author

Developed by **FEMI**.
