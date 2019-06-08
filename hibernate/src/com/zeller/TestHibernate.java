package com.zeller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

//        Product p = new Product();
//        p.setName("iphone7");
//        p.setPrice(7000);
//        s.save(p);

        for (int i = 0; i < 10; i++) {
            Product p = new Product();
            p.setName("iphone"+i);
            p.setPrice(i);
            s.save(p);
        }

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}