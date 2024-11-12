package com.example.concurrency.model;
import java.util.Date;

public class Employee {

    private int id;
    private String name;
    private double salary;
    private Date joinedDate;
    private String role;
    private double percentageOfCompletedProjects;

    //Getter and Setter

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }

    public Date getJoinedDate() {
        return joinedDate;
    }

    public void setJoinedDate(Date joinedDate) {
        this.joinedDate = joinedDate;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    public double getPercentageOfCompletedProjects() {
        return percentageOfCompletedProjects;
    }

    public void setPercentageOfCompletedProjects(double percentageOfCompletedProjects) {
        this.percentageOfCompletedProjects = percentageOfCompletedProjects;
    }




}
