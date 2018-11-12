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
@WebServlet("/Wsg")
public class Wsg extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	private ProductDAO productDAO;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public Wsg() {
        super();
        // TODO Auto-generated constructor stub
        this.productDAO = new ProductDAO();
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Gson gson = new Gson();
		response
			.addHeader("Content-Type", "Application/JSON");
		
		response
			.getWriter()
			.append(gson.toJson(this.productDAO.getProducts()));
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		BufferedReader reader = request.getReader();
		Gson gson = new Gson();

		Product product = gson.fromJson(reader, Product.class);
		
		this.productDAO.addProduct(product);
		
		response.getWriter().append("{\"ok\": true}");
	}

}
