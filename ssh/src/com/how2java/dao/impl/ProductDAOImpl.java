package com.how2java.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate3.HibernateTemplate;

import com.how2java.dao.ProductDAO;
import com.how2java.pojo.Product;

public class ProductDAOImpl extends HibernateTemplate implements ProductDAO{
	
	public List<Product> list() {
		String name = "c";
		return find("from Product p where p.name LIKE '%"+name+"%'");
	}

	@Override
	public void add(Product p) {
		save(p);
	}
	
}
