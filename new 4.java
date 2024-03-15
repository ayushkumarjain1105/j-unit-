package com.example.demo;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class AnotherClassTest {

    private AnotherClass anotherClass;
    private Employee employee;

    @BeforeEach
    public void setUp() {
        anotherClass = new AnotherClass();
        // Creating a sample Employee object for testing
        employee = new Employee(1L, "John", "Doe", "Engineering");
    }

    @Test
    public void testProcessEmployee() {
        // Test processEmployee method
        String expectedOutput = "Processing employee: Employee{id=1, firstName='John', lastName='Doe', department='Engineering'}\n" +
                "Employee ID: 1\n" +
                "Employee Name: John Doe\n" +
                "Employee Department: Engineering\n";
        Assertions.assertEquals(expectedOutput, TestUtils.getConsoleOutput(() -> anotherClass.processEmployee(employee)));
    }

    @Test
    public void testCalculateSalary() {
        // Test calculateSalary method
        double expectedSalary = 50000; // Assuming fixed salary
        Assertions.assertEquals(expectedSalary, anotherClass.calculateSalary(employee));
    }

    @Test
    public void testPromoteEmployee() {
        // Test promoteEmployee method
        double incrementPercentage = 10; // 10% increment
        double expectedNewSalary = 55000; // Assuming 10% increment on fixed salary
        Assertions.assertEquals(expectedNewSalary, TestUtils.getPromotedSalary(() -> anotherClass.promoteEmployee(employee, incrementPercentage)));
    }

    // Helper class to capture console output
    static class TestUtils {
        public static String getConsoleOutput(Runnable runnable) {
            // Redirect console output to string
            java.io.ByteArrayOutputStream outContent = new java.io.ByteArrayOutputStream();
            System.setOut(new java.io.PrintStream(outContent));
            // Run the method
            runnable.run();
            // Reset console output
            System.setOut(null);
            return outContent.toString();
        }

        public static double getPromotedSalary(Runnable runnable) {
            // Capture the printed new salary from console output
            String consoleOutput = getConsoleOutput(runnable);
            // Extract and parse the new salary
            String[] lines = consoleOutput.split("\n");
            String lastLine = lines[lines.length - 1];
            return Double.parseDouble(lastLine.split(": ")[1]);
        }
    }
}
