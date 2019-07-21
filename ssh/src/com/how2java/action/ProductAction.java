package com.how2java.action;

import java.util.List;

import com.how2java.pojo.Product;
import com.how2java.service.ProductService;

public class ProductAction {

	ProductService productService;
	List<Product> products;
	Product product;
	public String list() {
		products = productService.list();
		return "listJsp";
	}

	public String add(){
		System.out.println("product.name:"+product.getName());
		productService.add(product);
		products = productService.list();
		return "add";
	}

	public String del(){
		System.out.println("product.id:"+product.getId());
		productService.del(product);
		products = productService.list();
		return "del";
	}

	public ProductService getProductService() {
		return productService;
	}

	public void setProductService(ProductService productService) {
		this.productService = productService;
	}

	public List<Product> getProducts() {
		return products;
	}

	public void setProducts(List<Product> products) {
		this.products = products;
	}

	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}
}
