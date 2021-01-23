package com.wipro.sales.bean;

import java.util.Date;

public class Sales {
	
	String salesID;
    java.util.Date salesDate;
    String productID;
    int quantitySold;
    double SalesPricePerUnit;
    public Sales(Date salesDate, String productID, int quantitySold, double salesPricePerUnit) {
		super();
		this.salesDate = salesDate;
		this.productID = productID;
		this.quantitySold = quantitySold;
		this.salesPricePerUnit = salesPricePerUnit;
	}
	double salesPricePerUnit;
    
    public  Sales() {
		// TODO Auto-generated constructor stub
	}
	public String getSalesID() {
		return salesID;
	}
	public void setSalesID(String salesID) {
		this.salesID = salesID;
	}
	public java.util.Date getSalesDate() {
		return salesDate;
	}
	public void setSalesDate(java.util.Date salesDate) {
		this.salesDate = salesDate;
	}
	public String getProductID() {
		return productID;
	}
	public void setProductID(String productID) {
		this.productID = productID;
	}
	public int getQuantitySold() {
		return quantitySold;
	}
	public void setQuantitySold(int quantitySold) {
		this.quantitySold = quantitySold;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
    

}
