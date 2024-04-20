package com.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class Main {
    public static void main(String[] args) {

        System.out.println("Hello world!");

       // making session factory object
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

          //making student object
        Student student = new Student();
        student.setId(2);
        student.setName("anuj");
        student.setCity("Delhi");

        System.out.println(student);


        //making session object
        Session session = factory.openSession();

        //begin transaction
        session.beginTransaction();

        //save student object
        session.save(student);

        //commit transaction
        session.getTransaction().commit();

        //closing session
        session.close();


    }
}