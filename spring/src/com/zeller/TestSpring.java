package com.zeller;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

        Category c = (Category) context.getBean("c");

        System.out.println(c.getCat());
        Product p = (Product) context.getBean("p");
        System.out.println(p.getName());
        System.out.println(p.getCategory().getCat());
    }
}