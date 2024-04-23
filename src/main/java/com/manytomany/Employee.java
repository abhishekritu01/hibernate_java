package com.manytomany;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Employee {

    @Id
    private int empId;
    private String empName;

    @ManyToMany
    @JoinTable(name = "emp_proj", joinColumns = @JoinColumn(name = "empId"), inverseJoinColumns = @JoinColumn(name = "pId"))
    private List<Project> projects;

    public int getEmpId() {
        return empId;
    }

    public void setEmpId(int empId) {
        this.empId = empId;
    }

    public String getEmpName() {
        return empName;
    }

    public void setEmpName(String empName) {
        this.empName = empName;
    }

    public List<Project> getProjects() {
        return projects;
    }

    public void setProjects(List<Project> projects) {
        this.projects = projects;
    }

    public Employee(int empId, String empName, List<Project> projects) {
        this.empId = empId;
        this.empName = empName;
        this.projects = projects;
    }

    public Employee() {
        super();
    }

    @Override
    public String toString() {
        return "Employee{" +
                "empId=" + empId +
                ", empName='" + empName + '\'' +
                ", projects=" + projects +
                '}';
    }
}
