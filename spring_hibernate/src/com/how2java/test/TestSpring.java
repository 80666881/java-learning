package com.how2java.test;
 
import java.util.List;
import org.hibernate.criterion.DetachedCriteria;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.how2java.dao.CategoryDAO;
import com.how2java.pojo.Category;
 
 
public class TestSpring {
 
    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });
        CategoryDAO dao = (CategoryDAO) context.getBean("dao");
//        Category c = new Category();
//        c.setName("category yyy");
//
//        //����
//        dao.save(c);
//
//        //��ȡ
//        Category c2 = dao.get(Category.class, 1);
//
//        //�޸�
//        c2.setName("category zzz");
//        dao.update(c2);
//
//        //ɾ��
//        dao.delete(c2);


        //ʹ��DetachedCriteria���з�ҳ��ѯ
//        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//        int start =5;//�Ӷ��ٿ�ʼ��ѯ
//        int count =10;//ÿҳ��ʾ����
//        List<Category> cs= dao.findByCriteria(dc,start,count);
//        System.out.println(cs);




        //��ѯ����
        List<Long> l =dao.find("select count(*) from Category c");
        long total = l.get(0);
        System.out.println(total);
        

    }
}