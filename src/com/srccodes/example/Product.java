package com.srccodes.example;

/**
 * @author sap
 *
 */
public class Product {
	
	private long id;
	private String name;
	private double value;
	private String currencyCode;
	
	public Product() {}
	
	public Product(long id, String name, double value, String currencyCode) {
		super();
		this.id = id;
		this.name = name;
		this.value = value;
		this.currencyCode = currencyCode;
	}
	
	public long getId() {
		return id;
	}
	public void setId(long id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getValue() {
		return value;
	}
	public void setValue(double value) {
		this.value = value;
	}
	public String getCurrencyCode() {
		return currencyCode;
	}
	public void setCurrencyCode(String currencyCode) {
		this.currencyCode = currencyCode;
	}
}
