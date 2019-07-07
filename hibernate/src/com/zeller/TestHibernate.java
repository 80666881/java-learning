package com.zeller;
import java.util.HashSet;
import java.util.Iterator;
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


        //多对一
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//        Session s = sf.openSession();
//        s.beginTransaction();
//
//        //这里更新Category表，id自增
//        Category c =new Category();
//        c.setName("c1");
//        s.save(c);
        //设置id=8的产品对应的cid为1
        //category和product表的关联在Category的hbm里设置，表示cid即为product的外键，关联自己的主键
//        Product p1 = (Product) s.get(Product.class, 8);
//        p1.setCategory(c);
//        s.update(p1);
//
//        //设置id=6的产品对应的cid为1
//        Product p2 = (Product) s.get(Product.class, 6);
//        p2.setCategory(c);
//        s.update(p2);
//
//        s.getTransaction().commit();
//        s.close();
//        sf.close();



        //一对多,打印cid=5的产品名称
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//        Session s = sf.openSession();
//        s.beginTransaction();
//
//        Category c = (Category) s.get(Category.class, 5);
//        Set<Product> ps = c.getProducts();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//        }
//
//        s.getTransaction().commit();
//        s.close();
//        sf.close();



        //多对多

        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        //增加3个用户
        Set<User> users = new HashSet();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }

        //产品1被用户1,2,3购买（自增）
        Product p1 = (Product) s.get(Product.class, 1);

        p1.setUsers(users);
        s.save(p1);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}