# Employee Management System

This is a full stack application built using Angular 13, Angular Material, Java 17, Spring Boot, and MySQL database. It allows users to manage employee details including creating new employees, reading employee information, updating employee details, and deleting employee records.

## Prerequisites

Before running this application, make sure you have the following installed:

- Node.js
- Angular CLI
- Java Development Kit (JDK)
- MySQL database

## Installation

1. Clone the repository:

```bash
git clone https://github.com/SuyashMisra/Angular-13-Spring-Boot-CRUD-App.git
```

2. Change into the project directory:

```bash
cd Employee-Management
```

3. Install the dependencies for both frontend and backend:

```bash
# Install frontend dependencies
cd '.\Angular Frontend'
npm install

# Install backend dependencies
cd .\springboot-backend
./mvnw install
```

4. Configure the database connection in `springboot-backend/src/main/resources/application.properties` file:

```properties
spring.datasource.url=jdbc:mysql://localhost:3306/employee_management_system?useSSL=false&serverTimezone=UTC&allowPublicKeyRetrieval=true
spring.datasource.username=root
spring.datasource.password=password
```

Make sure to replace `root` with your MySQL username and `password` with your MySQL password.

5. Create a new database named `employee_management_system` in your MySQL server.

6. Run the backend server:

```bash
cd ../springboot-backend/
./mvnw spring-boot:run
```

7. Run the frontend development server:

```bash
cd '../Angular Frontend/'
ng serve --open
```

This will open the application in your default browser at `http://localhost:4200`.

## Usage

Once the application is running, you can perform various operations on employee records using the provided user interface.

### Create Employee

To create a new employee record:
1. Click on "Create Employee" button.
2. Fill in the employee details in the form.
3. Click on "Submit" button to create the employee.

### Read Employees

To view all employees:
1. Click on "Employee List" button.
2. A table will be displayed showing all existing employees.

### Update Employee Details

To update an employee's details:
1. Click on "Employee List" button.
2. Find the employee you want to update in the table.
3. Click on the update option in the dropdown menu next to the employee's record.
4. Update the employee details in the form.
5. Click on "Submit" button to update the employee.

### Delete Employee Details

To delete an employee's record:
1. Click on "Employee List" button.
2. Find the employee you want to delete in the table.
3. Click on the delete option in the dropdown menu next to the employee's record.
4. Confirm the deletion when prompted.

## Contributing

Contributions are welcome! If you find any issues or have suggestions for improvement, please create a new issue or submit a pull request.

## License

This project is licensed under the [MIT License](LICENSE).