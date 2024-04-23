package com.spring;


import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class EmbededDemo {
    public static void main(String[] args) {


//        SessionFactory factory = new Configuration().configure().buildSessionFactory();
//
//        Student student = new Student();
//        student.setId(5);
//        student.setName("Vansh");
//        student.setCity("Sitamarhi");
//
//        Certificates certificate = new Certificates();
//        certificate.setCourse("Java");
//        certificate.setDuration("6 Month");
//
//        // Associate certificate with student
//        student.setCertificates(certificate);
//
//
//        Student student1 = new Student();
//        student1.setId(6);
//        student1.setName("abc");
//        student1.setCity("Delhi");
//
//        Certificates certificate1 = new Certificates();
//        certificate1.setCourse("core Java");
//        certificate1.setDuration("4 Month");
//
//        // Associate certificate1 with student1
//        student1.setCertificates(certificate1);
//
//        Session session = factory.openSession();
//        session.beginTransaction();
//        session.save(student);
//        session.save(student1);
//        session.getTransaction().commit();
//        session.close();
//        factory.close();



        SessionFactory factory = new Configuration().configure().buildSessionFactory();

        Student student = new Student();
        student.setId(5);
        student.setName("Vansh");
        student.setCity("Sitamarhi");

        Certificates certificate = new Certificates();
        certificate.setCourse("Java");
        certificate.setDuration("6 Month");
        student.setCertificates(certificate);

        Student student1 = new Student();
        student1.setId(6);
        student1.setName("abc");
        student1.setCity("Delhi");

        Certificates certificate1 = new Certificates();
        certificate1.setCourse("core Java");
        certificate1.setDuration("4 Month");
        student1.setCertificates(certificate1);

        Student student2 = new Student();
        student2.setId('7');
        student2.setName("mahi");
        student2.setCity("Sitamarhi");

        Certificates certificate2 = new Certificates();
        certificate2.setCourse("core Java");
        certificate2.setDuration("4 Month");
        student2.setCertificates(certificate2);




        Session session = factory.openSession();
        session.beginTransaction();
        session.save(student);
        session.save(student1);
        session.save(student2);
        session.save(certificate);
        session.getTransaction().commit();
        session.close();
        factory.close();

    }
}
