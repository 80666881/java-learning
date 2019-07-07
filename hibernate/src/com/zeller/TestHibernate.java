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
        //使用Criteria进行分页查询
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//
//        Session s = sf.openSession();
//        s.beginTransaction();
//
//        String name = "iphone";
//
//        Criteria c= s.createCriteria(Product.class);
//        c.add(Restrictions.like("name", "%"+name+"%"));
//        c.setFirstResult(2);//从第3条数据开始
//        c.setMaxResults(5);//查询5条数据
//
//        List<Product> ps = c.list();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//
//        }
//
//        s.getTransaction().commit();
//        s.close();
//        sf.close();


        //查询符合条件的总数
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        String name = "iphone";

        Query q =s.createQuery("select count(*) from Product p where p.name like ?");
        q.setString(0, "%"+name+"%");
        long total= (Long) q.uniqueResult();
        System.out.println(total);
        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}