package com.zeller;

import org.springframework.stereotype.Component;

//@Component("c")
public class Category {
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public String getCat() {
        return catName;
    }
    public void setCat(String name) {
        this.catName = name;
    }
    private int id;
    private String catName="category 1";
}
