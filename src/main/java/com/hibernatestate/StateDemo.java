package com.hibernatestate;

import com.spring.Certificates;
import com.spring.Student;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class StateDemo {

    public static void main(String[] args) {
        // hibernate state
        // Transient state     Persistent state     Detached state     Removed state

        // Transient state
        // object is not associated with any session and has no representation in the database
        System.out.println("Transient state");

        SessionFactory factory = new Configuration().configure().buildSessionFactory();


      // 1.transient state
        Student student = new Student();
        student.setId(101);
        student.setName("Rahul");
        student.setCity("Pune");
//        student.setCertificates(new Certificates('java','2 months'));

        // 2. persistent state
        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);

        student.setName("Raj");


        session.getTransaction().commit();
        session.close();
        factory.close();


    }
}
