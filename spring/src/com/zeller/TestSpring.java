package com.zeller;

import com.zeller.service.ProductService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class TestSpring {

    public static void main(String[] args) {
        ApplicationContext context = new ClassPathXmlApplicationContext(
                new String[] { "applicationContext.xml" });

        /*
        * AOP
        *   面向切面编程
        *   周边功能在Spring的面向切面编程AOP思想里，即被定义为切面
            在面向切面编程AOP的思想里面，核心业务功能和切面功能分别独立进行开发
            然后把切面功能和核心业务功能 "编织" 在一起，这就叫AOP
        * */
        ProductService s = (ProductService) context.getBean("s");
        s.doSomeService();
    }
}