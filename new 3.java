package com.example.demo;

public class AnotherClass {

    // Method that takes an Employee object as a parameter
    public void processEmployee(Employee employee) {
        // Here you can perform operations with the passed Employee object
        System.out.println("Processing employee: " + employee);
        // You can access the properties of the Employee object using getter methods
        System.out.println("Employee ID: " + employee.getId());
        System.out.println("Employee Name: " + employee.getFirstName() + " " + employee.getLastName());
        System.out.println("Employee Department: " + employee.getDepartment());

        // You can add more logic here as needed
    }

    // Method to calculate and return the total salary of an employee
    public double calculateSalary(Employee employee) {
        // For simplicity, let's assume a fixed salary per employee
        // You can replace this with your salary calculation logic
        double salary = 50000; // Example fixed salary
        return salary;
    }

    // Method to promote an employee by increasing salary
    public void promoteEmployee(Employee employee, double incrementPercentage) {
        // For simplicity, let's assume the promotion is a fixed percentage increment
        // You can replace this with your promotion logic
        double currentSalary = calculateSalary(employee);
        double incrementAmount = currentSalary * (incrementPercentage / 100);
        double newSalary = currentSalary + incrementAmount;

        // Update the employee's salary
        // For now, let's just print the new salary, you might want to update it in the database or elsewhere
        System.out.println("Employee promoted! New salary: " + newSalary);
    }

    // Method to terminate an employee
    public void terminateEmployee(Employee employee) {
        // For simplicity, let's just print a message indicating termination
        System.out.println("Employee terminated: " + employee.getFirstName() + " " + employee.getLastName());
        // You might want to perform other cleanup tasks here, such as updating database records
    }
}
