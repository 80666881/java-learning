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
    /*
    *   Hibernate N+1
    *   Hibernate有缓存机制，可以通过用id作为key把product对象保存在缓存中

        同时hibernate也提供Query的查询方式。假设数据库中有100条记录，其中有30条记录在缓存中，但是使用Query的list方法，就会所有的100条数据都从数据库中查询，而无视这30条缓存中的记录

        N+1是什么意思呢，首先执行一条sql语句，去查询这100条记录，但是，只返回这100条记录的ID
        然后再根据id,进行进一步查询。

        如果id在缓存中，就从缓存中获取product对象了，否则再从数据库中获取
    *
    * */
    public static void main(String[] args) {
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();

        String name = "iphone";

        Query q =s.createQuery("from Product p where p.name like ?");

        q.setString(0, "%"+name+"%");

        Iterator<Product> it= q.iterate();
        while(it.hasNext()){
            Product p =it.next();
            System.out.println(p.getName());
        }

        s.getTransaction().commit();
        s.close();
        sf.close();
    }

}