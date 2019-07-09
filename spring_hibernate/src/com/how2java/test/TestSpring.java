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
//        //增加
//        dao.save(c);
//
//        //获取
//        Category c2 = dao.get(Category.class, 1);
//
//        //修改
//        c2.setName("category zzz");
//        dao.update(c2);
//
//        //删除
//        dao.delete(c2);


        //使用DetachedCriteria进行分页查询
//        DetachedCriteria dc = DetachedCriteria.forClass(Category.class);
//        int start =5;//从多少开始查询
//        int count =10;//每页显示数量
//        List<Category> cs= dao.findByCriteria(dc,start,count);
//        System.out.println(cs);




        //查询总数
        List<Long> l =dao.find("select count(*) from Category c");
        long total = l.get(0);
        System.out.println(total);
        

    }
}