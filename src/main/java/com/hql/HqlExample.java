package com.hql;

import com.spring.Address;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import java.util.List;

public class HqlExample {
    public static void main(String[] args) {

        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Session session = factory.openSession();

        // HQL Query
        String query = "from Address";
        org.hibernate.query.Query q = session.createQuery(query);
        List<Address> list = q.list();

        for (Address address : list) {
            System.out.println(address.getCity() + " : " + address.getStreet());
        }





        factory.close();
    }
}
