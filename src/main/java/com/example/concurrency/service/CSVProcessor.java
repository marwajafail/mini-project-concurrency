package com.example.concurrency.service;
import com.example.concurrency.model.Employee;
import org.springframework.stereotype.Service;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
public class CSVProcessor {
    // Path to the CSV file containing employee data
    private static final String FILE_PATH = "C:\\Users\\marooy990\\jdi\\projects\\mini-project-concurrency\\concurrency\\src\\main\\resources\\test_employees.csv";

    //Read CSV File
    public List<Employee> ReadCSV() {
        // list to save employee object in list
        List<Employee> employees = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(FILE_PATH))) {
            String line;

            while ((line = bufferedReader.readLine()) != null) {
                //read  line from the file and splits it into an array
                String[] data = line.split(",");
                Employee employee = new Employee();
                employee.setId(Integer.parseInt(data[0]));
                employee.setName(data[1]);
                employee.setSalary(Double.parseDouble(data[2]));
                employee.setJoinedDate(new SimpleDateFormat("yyyy-MM-dd").parse(data[3]));
                employee.setRole(data[4]);
                employee.setPercentageOfCompletedProjects(Double.parseDouble(data[5]));
                employees.add(employee); //Employee object added it to the list
            }
        } catch (IOException | ParseException e) {
             e.getMessage();
        }
        return employees;
    }
}