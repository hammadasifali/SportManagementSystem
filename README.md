# Sports Tournament Management System

## Overview

The Sports Tournament Management System is a Java-based Object-Oriented Programming (OOP) application utilizing Java Swing for the graphical user interface and JDBC (Java Database Connectivity) to interact with a Microsoft Access database. This system aims to streamline the management of sports tournaments, teams, players, and related information, providing administrators with a robust tool for organizing and overseeing various aspects of sports events.

## Object-Oriented Design

The project follows Object-Oriented Design principles, employing classes and abstraction to model real-world entities. The system is divided into several classes, each responsible for managing specific entities such as departments, members, players, teams, tournaments, schedules, and results. The use of inheritance and abstract classes enhances code reusability and maintainability.

## Features

### 1. **Department Management**
   - Add, update, and delete departments.
   - Manage department information, including name and head.

### 2. **Member Management**
   - Add, update, and delete members.
   - Manage member information, including name, email, password, and member role.

### 3. **Player Management**
   - Add, update, and delete players.
   - Manage player details, including name, department, and team.

### 4. **Team Management**
   - Add, update, and delete teams.
   - Manage team information, including name, department, and coach.

### 5. **Tournament Management**
   - Add, update, and delete tournaments.
   - Manage tournament details, including name, start date, end date, location, number of rounds, tournament type, and sport type.

### 6. **Schedule Management**
   - Add, update, and delete schedules.
   - Organize schedules based on teams, tournaments, sports, departments, locations, and dates.

### 7. **Results Management**
   - Add, update, and delete results.
   - Record tournament results, including the tournament name, winning team, and losing team.

## Technologies Used

- **Java Swing:** Provides a graphical user interface for easy interaction.
- **JDBC (Java Database Connectivity):** Enables interaction with a Microsoft Access database.
- **Object-Oriented Programming (OOP):** Utilizes classes, inheritance, and abstraction for a modular and maintainable codebase.
- **Microsoft Access Database:** Stores and manages data related to departments, members, players, teams, tournaments, schedules, and results.

## Getting Started

1. **Clone the Repository:**
   - Clone the project repository to your local machine.

2. **Database Connection:**
   - Configure the database connection by updating the URL in the `DbConnection` class constructor.

3. **Run the Application:**
   - Open the project in a Java IDE and run the application to launch the GUI.

4. **Explore the Features:**
   - Navigate through different sections to manage departments, members, players, teams, tournaments, schedules, and results.

## Object-Oriented Design

The project follows a clear object-oriented design with distinct classes for each entity, fostering modularity and code reuse. Abstraction is employed through abstract classes, allowing for consistent methods across different entities.


## License

- This project is licensed under the [MIT License](LICENSE), allowing flexibility in use, modification, and distribution.
