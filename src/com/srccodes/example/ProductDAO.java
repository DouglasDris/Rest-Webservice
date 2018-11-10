package com.srccodes.example;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	private List<Product> products = new ArrayList<Product>();
	
	
	public void addProduct(Product product) {
		this.products.add(product);
	}
	
	public Product getProductById(long id) {
		for (int i = 0; i < this.products.size(); i ++) {
			if (this.products.get(i).getId() == id) {
				return this.products.get(i);
			}
		}
		//not found
		return null;
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	//delete
	//update
	
}
