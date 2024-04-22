package com.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.ArrayList;
import java.util.List;

public class MapDataManytoMany {

    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Employee employee1 = new Employee();
        Employee employee2 = new Employee();

        employee1.setEmpId(1);
        employee1.setEmpName("Rahul");

        employee2.setEmpId(2);
        employee2.setEmpName("Raj");

        Project project1 = new Project();
        Project project2 = new Project();

        project1.setpId(101);
        project1.setProjectName("Hibernate");

        project2.setpId(102);
        project2.setProjectName("Spring");


        List<Employee> emp = new ArrayList<Employee>();
        List<Project> pro = new ArrayList<Project>();

        emp.add(employee1);
        emp.add(employee2);

        pro.add(project1);
        pro.add(project2);



        employee1.setProjects(pro);
        project2.setEmployee(emp);


        //---------start session --------------
        Session session = factory.openSession();
        session.beginTransaction();

        session.save(employee1);
        session.save(employee2);
        session.save(project1);
        session.save(project2);




        session.getTransaction().commit();
        session.close();
        factory.close();

    }
}
