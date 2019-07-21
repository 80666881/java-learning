package com.how2java.service;

import java.util.List;

import com.how2java.pojo.Product;

public interface ProductService {
	
	public List<Product> list();

	public void add(Product p);

	public void del(Product p);
}
