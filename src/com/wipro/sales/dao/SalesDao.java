package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;

import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.util.DBUtil;

public class SalesDao {
	static int seq_genrated_id=10;
	static String genrated_id="id";

	public String insertSales(Sales s) {
		// TODO Auto-generated method stub
		try{
			Connection con = DBUtil.getDBConnection();
			java.sql.Date dt=new java.sql.Date(s.getSalesDate().getTime());
			if(s!=null)
			{
				String product_id=s.getProductID();
				boolean flag=false;
				PreparedStatement pt=con.prepareStatement("select * from tbl_stock");
				ResultSet rs=pt.executeQuery();
				
				while(rs.next())
				{
						String pID=rs.getString(1);
						System.out.println(pID);
						if(product_id.equals(pID))
						{
							flag=true;
							System.out.println("Done");
							break;
						}
//						else {
//							flag=false;
//						}
				}
				if(flag=true)
				{
					int quantity_Sold=s.getQuantitySold();
					int temp=0;
							int quantityOnHand=rs.getInt(3);
							if(quantityOnHand>quantity_Sold)
							{
								temp=1;
							}
							else {
								temp=0;
							}
					
					if(temp==1)
					{
						long nextDay = System.currentTimeMillis() + 1000*60*60*24;
						 Date next = new Date(nextDay);
					        //compare both dates
					        if(next.after(dt))
					        {
					           String salesID=genrateSalesID(dt);
					           pt=con.prepareStatement("insert into tbl_sales values(?,?,?,?,?)");
					           pt.setString(1,salesID);
					           pt.setDate(2,dt);
					           pt.setString(3,s. getProductID());
					           pt.setInt(4,s.getQuantitySold());
					           pt.setDouble(5,s. getSalesPricePerUnit());
					           int n=pt.executeUpdate();
					           if(n>0)
					           {
					        	 // return salesID;
					        	   StockDao sd=new StockDao();
					        	   String updateConfirm=sd.updateStock(product_id,quantity_Sold);
					        	   return updateConfirm;
					        	   
					           }
					           else
					           {
					        	   return "Data can't be insert";
					           }
								
					        	
					        } 
					        else {
					            System.out.println("Invalid Date");
					        }
				
					}
					else
					{
						System.out.println("NOt enough stock on hand for sales!!");
					}
					
				}
				else
				{
					System.out.println("Unknown Product for Sales!!");
				}
			}
			else
			{
				System.out.println("Object not valid for insertion!!");
			}
		}
		catch(Exception g)
		{
			g.printStackTrace();
			return "can't be return!!!!";
		}
		
		return null;
	}

	public static String genrateSalesID(java.sql.Date dt) {
		// TODO Auto-generated method stub
		//java.sql.Date dt1=new java.sql.Date(s.getSalesDate().getTime());
		 String dateString = DateFormat.getDateInstance().format(dt); 
		 Calendar now = Calendar.getInstance();
		 now.setTime(dt);
		 int year = now.get(Calendar.YEAR);
		 int n=0,y;
		 String lastTwoDigit = "";
		 String sid="";
		 while(n < 2)
	        {
	            y = year % 10;
	            lastTwoDigit = y + "" +lastTwoDigit;
	            year = year / 10;
	            n++;
	        }
		sid=sid+seq_genrated_id+genrated_id+lastTwoDigit;		
		return sid;
	}

	public ArrayList<SalesReport> getSalesReport() {
		
		// TODO Auto-generated method stub
		ArrayList<SalesReport> sInfo=new ArrayList<SalesReport>();
		try{
			Connection con = DBUtil.getDBConnection();
			
			PreparedStatement pt=con.prepareStatement("SELECT tbl_sales.SALES_ID, tbl_sales.SALES_DATE, tbl_sales.PRODUCT_ID, tbl_sales.QUANTITY_SOLD, tbl_sales.SALES_PRICE_PER_UNIT, tbl_stock.PRODUCT_NAME, tbl_stock.PRODUCT_UNIT_PRICE\r\n FROM tbl_sales ,tbl_stock\r\n WHERE  tbl_sales.PRODUCT_ID =tbl_stock.PRODUCT_ID");
			ResultSet rs=pt.executeQuery();
			SalesReport sr;	
			while(rs.next())
			{
			//	System.out.println(rs.getString(1));

				 String sID = rs.getString("SALES_ID");
				 java.sql.Date date=rs.getDate("SALES_DATE");
				 String pID=rs.getString("PRODUCT_ID");
				 int quantity=rs.getInt("QUANTITY_SOLD");
				 double salesPrice=rs.getDouble("SALES_PRICE_PER_UNIT");
				 String pName=rs.getString("PRODUCT_NAME");
				 Double pUnitPrice=rs.getDouble("PRODUCT_UNIT_PRICE");
				 Double profit=pUnitPrice-salesPrice;
				 sr =new SalesReport(sID,date,pID,quantity,salesPrice,pName,pUnitPrice,profit);
				// sr=new SalesReport();
				 sr.setSalesID(sID);
				 sr.setSalesDate(date);
				 sr.setProductID(pID);
				 sr.setQuantitySales(quantity);
				 sr.setSalesPricePerUnit(salesPrice);
				 sr.setProductName(pName);
				 sr.setProductUnitPrice(pUnitPrice);
				 sr.setProfitAmount(profit);
				 sInfo.add(sr);
			}
			rs.close();
			pt.close();
			return sInfo;
			
			
			
	}catch(Exception g)
		{
		g.printStackTrace();
		return null;
	}
		
		
	}
}
