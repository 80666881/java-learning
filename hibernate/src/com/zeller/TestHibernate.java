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
    /*
    *   Hibernate使用Criteria 来进行分页查询
        c.setFirstResult(2); 表示从第3条数据开始
        c.setMaxResults(5); 表示一共查询5条数据
    *
    * */
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();

        Session s = sf.openSession();
        s.beginTransaction();

        String name = "iphone";

        Criteria c= s.createCriteria(Product.class);
        c.add(Restrictions.like("name", "%"+name+"%"));
        c.setFirstResult(2);
        c.setMaxResults(5);

        List<Product> ps = c.list();
        for (Product p : ps) {
            System.out.println(p.getName());

        }

        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}