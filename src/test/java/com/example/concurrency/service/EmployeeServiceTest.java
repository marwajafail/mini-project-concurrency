package com.example.concurrency.service;
import com.example.concurrency.model.Employee;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.Date;

import static org.junit.jupiter.api.Assertions.assertEquals;

class EmployeeServiceTests {

    private EmployeeService employeeService;

    @BeforeEach
    public void setUp() {
        employeeService = new EmployeeService();
    }
// to verify salary calculation based on role and project completion
    @Test
    public void testProcessEmployee() {
        Employee employee = new Employee();
        employee.setRole("Manager");
        // 5 years ago
        employee.setJoinedDate(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 5));
        employee.setSalary(1000.0);
        employee.setPercentageOfCompletedProjects(0.7);

        employeeService.processEmployee(employee);

       //new salary = 1000 * (1 + 0.02 + 0.10) = 1000 * 1.12 = 1120.0
        assertEquals(1120.0, employee.getSalary());
    }


    @Test
    public void testProcessEmployee_Manager() {
        Employee employee = new Employee();
        employee.setRole("Manager");
        // 5 years ago
        employee.setJoinedDate(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 5));
        employee.setSalary(1000.0);
        employee.setPercentageOfCompletedProjects(0.7);

        employeeService.processEmployee(employee);

        //  new salary = 1000 * (1 + 0.02 + 0.10) = 1000 * 1.12 = 1120.0
        assertEquals(1120.0, employee.getSalary(), 0.01);
    }


    @Test
    public void testProcessEmployee_Director() {
        Employee employee = new Employee();
        employee.setRole("Director");
        // 5 years ago
        employee.setJoinedDate(new Date(System.currentTimeMillis() - 1000L * 60 * 60 * 24 * 365 * 5));
        employee.setSalary(1000.0);
        employee.setPercentageOfCompletedProjects(0.7);

        employeeService.processEmployee(employee);

        //salary = 1000 * (1 + 0.05 + 0.10) = 1000 * 1.15 = 1150.0
        assertEquals(1150.0, employee.getSalary(), 0.01);
    }






}
