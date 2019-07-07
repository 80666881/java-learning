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

/*
    什么是级联？ 简单的说，没有配置级联的时候，删除分类，其对应的产品不会被删除。
    但是如果配置了恰当的级联，那么删除分类的时候，其对应的产品都会被删除掉。

*   包括上一步说的删除用得级联，级联有4种类型：
    all：所有操作都执行级联操作；
    none：所有操作都不执行级联操作；
    delete：删除时执行级联操作；
    save-update：保存和更新时执行级联操作；
    级联通常用在one-many和many-to-many上，几乎不用在many-one上。
*
* */
public class TestHibernate {
    public static void main(String[] args) {

        //delete级联
//        SessionFactory sf = new Configuration().configure().buildSessionFactory();
//        Session s = sf.openSession();
//        s.beginTransaction();
//        //删除Category的id为5的分类，并且删除关联的产品
//        Category c = (Category) s.get(Category.class, 5);
//        s.delete(c);
//        s.getTransaction().commit();
//        s.close();
//        sf.close();


        //save-update级联
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        Category c = (Category) s.get(Category.class, 4);

        Product p1 = new Product();
        p1.setName("product_501");
        Product p2 = new Product();
        p2.setName("product_502");
        Product p3 = new Product();
        p3.setName("product_503");

        c.getProducts().add(p1);
        c.getProducts().add(p2);
        c.getProducts().add(p3);

        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}