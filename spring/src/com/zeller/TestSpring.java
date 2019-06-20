package com.zeller;

import com.zeller.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

        Product p = (Product) context.getBean("p");
        //通过注解方式注入对象
        System.out.println(p.getCategory().getCat());
    }
}