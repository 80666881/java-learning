package com.zeller;

import com.zeller.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

        /*
        * 对Bean进行注解配置
        * 1.修改applicationContext.xml
        * 2.对bean类用@Component("")声明
        * */
        Product p = (Product) context.getBean("p");
        System.out.println(p.getName());
//        System.out.println(p.getCategory());
    }
}