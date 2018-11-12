package com.srccodes.example;

import java.util.ArrayList;
import java.util.List;

public class ProductDAO {
	
	private List<Product> products = new ArrayList<Product>();
	
	//Fake Query
	public Product getProductById(String id) {
		for (int i = 0; i < this.products.size(); i ++) {
			if (this.products.get(i).getId().equals(id)) {
				return this.products.get(i);
			}
		}
		//not found
		return null;
	}
	
	public List<Product> getProducts(){
		return this.products;
	}
	
	
	public void persist(Product product) {
		this.products.add(product);
	}
	
	//fake update/persist on db
	public void save(Product product) {}
	

	public void deleteById(String id) {
		for (int i = 0; i < this.products.size(); i ++) {
			if (this.products.get(i).getId().equals(id)) {
				this.products.remove(i);
			}
		}
	}
	
}
