package com.spring;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

public class Main {
    public static void main(String[] args) throws IOException {

        System.out.println("Hello world!");

       // making session factory object
        SessionFactory factory = new Configuration().configure().buildSessionFactory();

          //===================== 1/           creating student object
        Student student = new Student();
        student.setId(2);
        student.setName("anuj");
        student.setCity("Delhi");



        //========= creating object of Address Class =================
        Address address = new Address();
        address.setStreet("Street 1");
        address.setCity("Delhi");
        address.setOpen(true);
        address.setX(123.45);
        address.setAddedDate(new Date());   //import java.util.Date;

        // for image reading file and converting it into byte array
        FileInputStream fis = new FileInputStream("src/main/java/1.png");
        byte[] data = new byte[fis.available()];
        fis.read(data);
        address.setImage(data);








        //making session object
        Session session = factory.openSession();

        //begin transaction
        session.beginTransaction();

        //save student object
        session.save(student);
        session.save(address);

        //commit transaction
        session.getTransaction().commit();

        //closing session
        session.close();


    }
}