package com.example.concurrency.service;
import com.example.concurrency.model.Employee;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

@Service
public class ThreadPoolService {

    // Create a fixed thread pool with 7 threads
    private final ExecutorService executorservice = Executors.newFixedThreadPool(7);
    // To processes a list of employees concurrently using a thread pool
    public void processEmployeesConcurrently(List<Employee> employees, EmployeeService employeeService) {
        for (Employee employee : employees) {
            // Submit a task to process the employee to the thread pool
            executorservice.submit(() -> employeeService.processEmployee(employee));
        }
        // Shutdown the executor service after all tasks submitted
        executorservice.shutdown();
    }
}
