package com.srccodes.example;

import java.util.List;

public class ProductService {

	private ProductDAO productDAO;
	
	public ProductService() {
		this.productDAO = new ProductDAO();
	}

	public void addProduct(Product product) {
		this.productDAO.persist(product);
	};
	
	public List<Product> getProducts(){
		return this.productDAO.getProducts();
	}
	
	public Product getProductById(String id) {
		return this.productDAO.getProductById(id);
	}
	
	public void updateProductById(String id, Product payload) {
		Product originalProduct = this.getProductById(id);
		
		if (originalProduct != null) {
			originalProduct.setName(payload.getName());
			originalProduct.setValue(payload.getValue());
			originalProduct.setCurrencyCode(payload.getCurrencyCode());
		}
		
		this.productDAO.save(originalProduct);
	}
	
	public void deleteById(String id) {
		this.productDAO.deleteById(id);
	}

}
