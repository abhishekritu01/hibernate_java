package com.manytomany;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import java.util.List;

@Entity
public class Project {
    @Id
    private int pId;
    @Column(name = "project_name")
    private String projectName;


    @ManyToMany (mappedBy = "projects")
    private List<Employee> employee;

    public int getpId() {
        return pId;
    }

    public void setpId(int pId) {
        this.pId = pId;
    }

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

    public List<Employee> getEmployee() {
        return employee;
    }

    public void setEmployee(List<Employee> employee) {
        this.employee = employee;
    }



    public Project(int pId, String projectName, List<Employee> employee) {
        this.pId = pId;
        this.projectName = projectName;
        this.employee = employee;
    }

    public Project() {
        super();
    }

    @Override
    public String toString() {
        return "Project{" +
                "pId=" + pId +
                ", projectName='" + projectName + '\'' +
                ", employee=" + employee +
                '}';
    }
}
