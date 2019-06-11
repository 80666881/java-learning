package com.zeller;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {

//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//        Session s = sf.openSession();
//        s.beginTransaction();
//

//        s.getTransaction().commit();
//        s.close();
//        sf.close();

        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        //增
//        for (int i = 0; i < 10; i++) {
//            Product p = new Product();
//            p.setName("iphone"+i);
//            p.setPrice(i);
//            s.save(p);
//        }
//
//        Product p =(Product) s.get(Product.class, 6);
//        删
//        s.delete(p);

        //改
//        p.setName("iphone-modified");
//        s.update(p);


        //查get，非延迟，立即执行sql，拿不到返回null
//        Product p =(Product) s.get(Product.class, 6);

        //查load，延迟，返回属性才立即执行sql，拿不到返回null
        Product p =(Product) s.load(Product.class, 6);

        System.out.println("id=6的产品名称是: "+p.getName());

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}