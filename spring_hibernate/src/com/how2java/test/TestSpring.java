package com.how2java.test;
 
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.dao.CategoryDAO;
import com.how2java.pojo.Category;
 
 
public class TestSpring {
 
    public static void main(String[] args) {

        //ʹ��HibernateTemplate����ģ����ѯ
        //��˼·��ֱ��ʹ��hibernate��������
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        CategoryDAO dao = (CategoryDAO) context.getBean("dao");

        //ʹ��hql
        List<Category> cs =dao.find("from Category c where c.name like ?", "%c%");

        for (Category c : cs) {
            System.out.println(c.getName());
        }


        //ʹ��Criteria
        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
        dc.add(Restrictions.like("name", "%c%"));
        cs =dao.findByCriteria(dc);

        for (Category c : cs) {
            System.out.println(c.getName());
        }

    }
}