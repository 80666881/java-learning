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
        * 什么是级联？ 简单的说，没有配置级联的时候，删除分类，其对应的产品不会被删除。
        * 但是如果配置了恰当的级联，那么删除分类的时候，其对应的产品都会被删除掉。
        *
        *   包括上一步说的删除用得级联，级联有4种类型：
                all：所有操作都执行级联操作；
                none：所有操作都不执行级联操作；
                delete：删除时执行级联操作；
                save-update：保存和更新时执行级联操作；
            级联通常用在one-many和many-to-many上，几乎不用在many-one上。
        * */
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s = sf.openSession();
        s.beginTransaction();
        //级联delete
//        Category c = (Category) s.get(Category.class, 2);
//        s.delete(c);

        //级联update
        Category c = (Category) s.get(Category.class, 3);
        Product p1 = new Product();
        p1.setName("product_501");
        Product p2 = new Product();
        p2.setName("product_502");
        Product p3 = new Product();
        p3.setName("product_503");

        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}