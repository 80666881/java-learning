package com.zeller;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class TestHibernate {
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        /*
        *   通过标准SQL语句进行查询
            Hibernate依然保留了对标准SQL语句的支持，在一些场合，比如多表联合查询，并且有分组统计函数的情况下，标准SQL语句依然是效率较高的一种选择
        *
        * */
        Session s = sf.openSession();
        s.beginTransaction();
        String name = "iphone";
//        Query q =s.createQuery("from Product p where p.name like ?");
//        q.setString(0, "%"+name+"%");
//        List<Product> ps= q.list();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//        }
//        Criteria c= s.createCriteria(Product.class);
//        c.add(Restrictions.like("name", "%"+name+"%"));
//        List<Product> ps = c.list();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//        }
        String sql = "select * from product_ p where p.name like '%"+name+"%'";

        Query q= s.createSQLQuery(sql);
        List<Object[]> list= q.list();
        for (Object[] os : list) {
            for (Object filed: os) {
                System.out.print(filed+"\t");
            }
            System.out.println();
        }

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}