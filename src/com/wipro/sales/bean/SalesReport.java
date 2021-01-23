package com.wipro.sales.bean;

import java.sql.Date;

public class SalesReport {
	
	String salesID;
    java.util.Date salesDate;
    String productID;
    String productName;
    int quantitySales;	
    double productUnitPrice;
	double salesPricePerUnit;
	double profitAmount;
	
	public SalesReport(String salesID, java.util.Date salesDate, String productID, String productName,
			int quantitySales, double productUnitPrice, double salesPricePerUnit, double profitAmount) {
		super();
		this.salesID = salesID;
		this.salesDate = salesDate;
		this.productID = productID;
		this.productName = productName;
		this.quantitySales = quantitySales;
		this.productUnitPrice = productUnitPrice;
		this.salesPricePerUnit = salesPricePerUnit;
		this.profitAmount = profitAmount;
	}
	
	public SalesReport(String sID, Date date, String pID, int quantity, double salesPrice, String pName,
			Double pUnitPrice, Double profit) {
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
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public int getQuantitySales() {
		return quantitySales;
	}
	public void setQuantitySales(int quantitySales) {
		this.quantitySales = quantitySales;
	}
	public double getProductUnitPrice() {
		return productUnitPrice;
	}
	public void setProductUnitPrice(double productUnitPrice) {
		this.productUnitPrice = productUnitPrice;
	}
	public double getSalesPricePerUnit() {
		return salesPricePerUnit;
	}
	public void setSalesPricePerUnit(double salesPricePerUnit) {
		this.salesPricePerUnit = salesPricePerUnit;
	}
	public double getProfitAmount() {
		return profitAmount;
	}
	public void setProfitAmount(double profitAmount) {
		this.profitAmount = profitAmount;
	}
}
