package com.example.concurrency.service;
import com.example.concurrency.model.Employee;
import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;
//  to verify CSV reading functionality
 class CSVProcessorTests {

    @Test
    public void testReadCSV() {
        CSVProcessor csvProcessor = new CSVProcessor();
        List<Employee> employees = csvProcessor.ReadCSV();
        // Assert the employee list is not empty
        assertFalse(employees.isEmpty(), "The employee list must not be empty");
        // // Assert contains at least one employee
        assertTrue(employees.size() > 0, "The employee list must contain employees");
    }
}
