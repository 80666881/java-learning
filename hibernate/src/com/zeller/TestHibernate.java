package com.zeller;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {

        /*
        * hibernate一级缓存
        * hibernate默认是开启一级缓存的，一级缓存存放在session上
        *
        * */


        /*
        * 第一次通过id=1获取对象的时候，session中是没有对应缓存对象的，所以会在"log1"后出现sql查询语句。
          第二次通过id=1获取对象的时候，session中有对应的缓存对象，所以在"log2"后不会出现sql查询语句
        */
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();
        System.out.println("log1");
        Category c1 = (Category)s.get(Category.class, 1);
        System.out.println("log2");
        Category c2= (Category)s.get(Category.class, 1);
        System.out.println("log3");

        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}