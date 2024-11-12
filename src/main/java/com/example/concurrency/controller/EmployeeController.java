package com.example.concurrency.controller;
import com.example.concurrency.model.Employee;
import com.example.concurrency.service.CSVProcessor;
import com.example.concurrency.service.EmployeeService;
import com.example.concurrency.service.ThreadPoolService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private CSVProcessor csvProcessor;
    @Autowired
    private ThreadPoolService threadPoolService;
    @Autowired
    private EmployeeService employeeService;
    private List<Employee> employees = new ArrayList<>();

    //Endpoint to read CSV File
    @GetMapping("/readCSVFile")
    public String readCSV() {
        employees = csvProcessor.ReadCSV(); // Read CSV and store employees
        return "CSV file read successfully";
    }

    // Endpoint to process employees concurrently
    @GetMapping("/processEmployees")
    public String processEmployees() {
        if (employees.isEmpty()) {
            return "No employees to process. Please read the CSV file first.";
        }
        threadPoolService.processEmployeesConcurrently(employees, employeeService);
        return "Processing started";
    }

    // Endpoint to print employee details
    @GetMapping("/printEmployeeDetails")
    public List<Employee> printEmployeeDetails() {
        return employees;
    }
}
