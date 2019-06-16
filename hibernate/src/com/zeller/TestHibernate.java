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
        SessionFactory sf = new Configuration().configure().buildSessionFactory();
        /*
        *  hibernate多对一
        *
        * */
        Session s = sf.openSession();
        s.beginTransaction();

//        Category c =new Category();
//        //cid=2
//        c.setName("c2");
//        s.save(c);
//        Product p = (Product) s.get(Product.class, 8);
//        p.setCategory(c);
//        s.update(p);

//        //一对多
//        Category c = (Category) s.get(Category.class, 2);
//        Set<Product> ps = c.getProducts();
//        for (Product p : ps) {
//            System.out.println(p.getName());
//        }

        //多对多
        //增加3个用户
        Set<User> users = new HashSet();
        for (int i = 0; i < 3; i++) {
            User u =new User();
            u.setName("user"+i);
            users.add(u);
            s.save(u);
        }

        //产品1被用户1,2,3购买
        Product p1 = (Product) s.get(Product.class, 1);

        p1.setUsers(users);
        s.save(p1);
        s.getTransaction().commit();
        s.close();
        sf.close();

    }

}