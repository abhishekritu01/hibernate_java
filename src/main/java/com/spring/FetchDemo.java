package com.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;


public class FetchDemo {
    public static void main(String[] args) {

         // get or load
        // get method will return null if the object is not found in the database
        // load method will throw an exception if the object is not found in the database

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        Student student =(Student)session.get(Student.class, 2);
        Address address = (Address)session.load(Address.class, 1);
        System.out.println(student);
        System.out.println(address.getCity() + " : " + address.getStreet());



        session.close();
        factory.close();

    }
}
