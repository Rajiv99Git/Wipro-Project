package com.wipro.sales.bean;

public class Product {
	String productID;
	String productName;
	int quantityOnHand;
	double productUnitPrice;
	int reorderLevel;
	
	
	
	public Product(String productName, int quantityOnHand, double productUnitPrice, int reorderLevel) {
		super();
		this.productName = productName;
		this.quantityOnHand = quantityOnHand;
		this.productUnitPrice = productUnitPrice;
		this.reorderLevel = reorderLevel;
	}
	public Product() {
		// TODO Auto-generated constructor stub
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public String getProductName() {
		return productName;
	}
	
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantityOnHand() {
		return quantityOnHand;
	}
	public void setQuantityOnHand(int quantityOnHand) {
		this.quantityOnHand = quantityOnHand;
	}
	
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public int getReorderLevel() {
		return reorderLevel;
	}
	public void setReorderLevel(int reorderLevel) {
		this.reorderLevel = reorderLevel;
	}
	

}
