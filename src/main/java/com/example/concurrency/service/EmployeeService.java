package com.example.concurrency.service;
import java.util.Date;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;
import com.example.concurrency.model.Employee;
import org.springframework.stereotype.Service;

@Service
public class EmployeeService {

    private final Lock lock = new ReentrantLock();

    public void processEmployee(Employee employee) {
        double increment =  0.0;
        // Acquire the lock
        lock.lock();
        try {
            // Multiply by 100 to get percentage
            if (employee.getPercentageOfCompletedProjects() * 100 < 60) {
                return;
            }
            // // Calculate increment based on role
            increment = calculateRoleIncrement(employee.getRole());
            increment += calculateYearlyIncrement(employee.getJoinedDate());
            //if project completion is over 80%

            if (employee.getPercentageOfCompletedProjects() *100 > 80) {
                increment *= 1.5;
            }

            double newSalary = employee.getSalary() * (1 + increment );
            employee.setSalary(newSalary);
        } finally {
            lock.unlock();
        }
    }


    private double calculateRoleIncrement(String role) {
        switch (role) {
            case "Director":
                return 0.05;
            case "Manager":
                return 0.02;
            case "Employee":
                return 0.01;
            default:
                return 0.0;
        }
    }

    // Calculate Years Worked
    private long calculateYearsWorked(Date joinDate) {
        // Get the current date
        Date currentDate = new Date();

        // Calculate the difference in milliseconds
        long timeDifferenceInMillis = currentDate.getTime() - joinDate.getTime();

        // Convert milliseconds to years
        long millisecondsInYear = 1000L * 60 * 60 * 24 * 365;
        long yearsWorked = timeDifferenceInMillis / millisecondsInYear;

        return yearsWorked;
    }

    // Calculate the number of years worked
    private double calculateYearlyIncrement(Date joinDate) {
        long yearsWorked = calculateYearsWorked(joinDate);

        // Calculate the yearly increment
        double yearlyIncrement = yearsWorked * 0.02;

        // Return the increment when non-negative
        if (yearlyIncrement > 0) {
            return yearlyIncrement;
        } else {
            return 0;
        }
    }


}
