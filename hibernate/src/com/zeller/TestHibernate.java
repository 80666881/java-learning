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
        * 关系延迟加载
        * 延迟加载又叫lazyload，在one-many many-many的时候都可以使用关系的延迟加载
        * 1.修改配置文件 Category.hbm.xml
        * 2.执行25行的时候，只会查询Category表的信息，不会查询product_表
            只有在执行28行，通过category取products的时候，才会进行对product_表的查询
        * */
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Category c = (Category) s.get(Category.class, 1);

        System.out.println("log1");
        System.out.println(c.getProducts());
        System.out.println("log2");

        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}