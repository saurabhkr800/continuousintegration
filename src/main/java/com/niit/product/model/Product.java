package com.niit.product.model;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document
public class Product {
	
	@Id
	private String productCode;
	private String productName;
	private int price;
	private String available;
	
	
	public Product() {
		super();
	}


	public Product(String productCode, String productName, int price, String available) {
		super();
		this.productCode = productCode;
		this.productName = productName;
		this.price = price;
		this.available = available;
	}


	public String getProductCode() {
		return productCode;
	}


	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}


	public String getProductName() {
		return productName;
	}


	public void setProductName(String productName) {
		this.productName = productName;
	}


	public int getPrice() {
		return price;
	}


	public void setPrice(int price) {
		this.price = price;
	}


	public String getAvailable() {
		return available;
	}


	public void setAvailable(String available) {
		this.available = available;
	}

	@Override
	public String toString() {
		return "Product [productCode=" + productCode + ", productName=" + productName + ", price=" + price
				+ ", available=" + available + "]";
	}

}