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
* 两种锁的使用场景
从上面对两种锁的介绍，我们知道两种锁各有优缺点，不可认为一种好于另一种，
* 像乐观锁适用于写比较少的情况下（多读场景），即冲突真的很少发生的时候，这样可以省去了锁的开销，加大了系统的整个吞吐量。
* 但如果是多写的情况，一般会经常产生冲突，这就会导致上层应用会不断的进行retry，这样反倒是降低了性能，所以一般多写的场景下用悲观锁就比较合适。
*
* */
public class TestHibernate {
    public static void main(String[] args) {
       //使用乐观锁处理脏数据

        //核心是在Product.hbm.xml添加一个version字段，用于版本信息控制
//        <version name="version" column="ver" type="int"></version>
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        Session s1 = sf.openSession();
        Session s2 = sf.openSession();

        s1.beginTransaction();
        s2.beginTransaction();

        Product p1 = (Product) s1.get(Product.class, 1);
        System.out.println("产品原本价格是: " + p1.getPrice());

        p1.setPrice(p1.getPrice() + 1000);

        Product p2 = (Product) s2.get(Product.class, 1);
        p2.setPrice(p2.getPrice() + 1000);

        s1.update(p1);
        s2.update(p2);

        s1.getTransaction().commit();
        s2.getTransaction().commit();

        Product p = (Product) s1.get(Product.class, 1);

        System.out.println("经过两次价格增加后，价格变为: " + p.getPrice());

        s1.close();
        s2.close();

        sf.close();
    }

}