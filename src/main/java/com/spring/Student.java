package com.spring;


import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;



//@Entity(name = "student_details")
//@Table(name = "student_details")
@Entity
public class Student {

    @Id
    private int id;
    private String name;
    private String city;

    public Student(Certificates certificates) {
        this.certificates = certificates;
    }

    private Certificates certificates;

    public Certificates getCertificates() {
        return certificates;
    }

    public void setCertificates(Certificates certificates) {
        this.certificates = certificates;
    }

    public Student(int id, String name, String city) {
        super();
        this.id = id;
        this.name = name;
        this.city = city;

    }


    public Student() {
        super();
    }


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

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }


    @Override
    public String toString() {
        return "Student{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", city='" + city + '\'' +
                '}';
    }
}
