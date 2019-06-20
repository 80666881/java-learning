package com.zeller;
import org.hibernate.envers.Audited;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.Resource;
@Component("p")
public class Product {
    private int id;
    private String name = "product 123";

    //可以通过@Autowired和@Resource，在变量声明处注入
//    @Autowired
//    @Resource(name="c")，name要和xml配置名字对应上,或者不填，此时Category也要是一个bean,需要用@Component声明
    @Resource
    private Category category;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getName() {
        return name;
    }
    public void setName(String name) {
        this.name = name;
    }

    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }
}
