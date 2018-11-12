package com.srccodes.example;

import java.io.BufferedReader;
import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

/**
 * Servlet implementation class Wsg
 */
@WebServlet("/v1/Products/*")
public class ProductsAPI extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private static String PATH_NAME = "/WsgServlet/v1/Products/";
	
	private ProductService productService;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public ProductsAPI() {
        super();
        this.productService = new ProductService();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Gson gson = new Gson();
		response
			.addHeader("Content-Type", "Application/JSON");
		
		
		String productId = this.getProductFromRequestPath(request.getRequestURI());
		
		//Get Product by ID
		if (productId != null) {
			Product retrievedProduct = this.productService.getProductById(productId);
			
			response
				.getWriter()
				.append(gson.toJson(retrievedProduct));
		}else { //Get Product List
			response
				.getWriter()
				.append(gson.toJson(this.productService.getProducts()));
		}
		
	}
	
	private String getProductFromRequestPath(String requestPath) {
		
		if (requestPath.length() < PATH_NAME.length()) {
			return null;
		}else {
			return requestPath.substring(PATH_NAME.length(), requestPath.length());
		}
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		

		Product product = this.getProductFromRequestBody(request);
		
		this.productService.addProduct(product);
		
		response.getWriter().append("{\"ok\": true}");
	}
	
	
	private Product getProductFromRequestBody(HttpServletRequest request) throws IOException {
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();

		return gson.fromJson(reader, Product.class);
	}
	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = this.getProductFromRequestPath(request.getRequestURI());
		
		Product productPayload = this.getProductFromRequestBody(request);
		
		this.productService.updateProductById(productId, productPayload);
	}
	
	
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String productId = this.getProductFromRequestPath(request.getRequestURI());
		
		this.productService.deleteById(productId);
	}

};
