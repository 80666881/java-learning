package com.zeller.service;

import org.springframework.stereotype.Component;

@Component("s")
public class ProductService {
    public void doSomeService(){
        System.out.println("doSomeService");
    }
    public void doSomeService2(){
        System.out.println("2222");
    }
}
