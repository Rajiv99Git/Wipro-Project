package com.wipro.sales.service;

import java.util.ArrayList;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.dao.SalesDao;
import com.wipro.sales.dao.StockDao;

public class Administrator {

	public String insertStockStock(Product p){
		StockDao sd=new StockDao();
		String pid=sd.insertStock(p);
		return pid;
	}

	public ArrayList<Product> getinfo(String pid) {
		// TODO Auto-generated method stub
		StockDao sd=new StockDao();
		ArrayList<Product> pList = sd.getProductList(pid);
		return pList;
	}

	public String dltStock(String pid) {
		// TODO Auto-generated method stub
		StockDao sd=new StockDao();
		String deleteInfo=sd.deleteStock(pid);
		return deleteInfo;
		
		
	}

	public String insertSales(Sales s) {
		// TODO Auto-generated method stub
		SalesDao sd=new SalesDao();
		String sid=sd.insertSales(s);
		return sid;
	}

	public ArrayList<SalesReport> getSalesReport() {
		// TODO Auto-generated method stub
		SalesDao sd=new SalesDao();
		ArrayList<SalesReport> report = sd.getSalesReport();
		return report;
	}
}
