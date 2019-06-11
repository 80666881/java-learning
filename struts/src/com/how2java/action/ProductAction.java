package com.how2java.action;

import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.struts2.ServletActionContext;

import com.how2java.bean.Product;
import com.opensymphony.xwork2.ActionContext;
//import com.opensymphony.xwork2.ActionSupport;

public class ProductAction {
	private Product product;

	public String show() {
		HttpServletRequest request = ServletActionContext.getRequest();
		HttpServletResponse response = ServletActionContext.getResponse();

		System.out.println("request:\t" + request);
		System.out.println("response:\t" + response);
		product = new Product();
		product.setName("iphone7");
		product.setId(23);
		return "showJsp";
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

	public String add(){
		Map m = ActionContext.getContext().getSession();
		m.put("name", product.getName());
		System.out.println("product.name:"+product.getName());
		return "showJsp";
	}
}