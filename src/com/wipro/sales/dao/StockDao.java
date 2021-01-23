package com.wipro.sales.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import com.wipro.sales.bean.Product;
import com.wipro.sales.util.DBUtil;

public class StockDao {

	static int seq_genrated_id=1001;
	public String insertStock(Product p) {
		// TODO Auto-generated method stub
		
		try{
			Connection con = DBUtil.getDBConnection();
			String productname=p.getProductName();
			String productID=genrateProductID(productname);
			PreparedStatement pt=con.prepareStatement("insert into tbl_stock values(?,?,?,?,?)");
			pt.setString(1,productID);
			pt.setString(2,p.getProductName());
			pt.setInt(3,p.getQuantityOnHand());
			pt.setDouble(4,p.getProductUnitPrice());
			pt.setInt(5,p.getReorderLevel());
			int n=pt.executeUpdate();
			if(n>0)
			{
				return productID;
			}
			else
			{
				return "Data can't be insert";
			}
			
			
			
		//return null;
		}
		catch(Exception g)
		{
			g.printStackTrace();
			return "can't be return!!!!";
		}


}
	public static String genrateProductID(String productname) {
		// TODO Auto-generated method stub
		 String pid="";
		int length=productname.length();
		if(length>=2)
		{
			String firstTwoChar=productname.substring(0,2);
			pid=pid+firstTwoChar+seq_genrated_id;
			seq_genrated_id=seq_genrated_id+1;
		}
		else {
			System.out.println("Data not valid for insertion because length of Product Name less than 2 !!!");
			System.exit(0);
		}
		return pid;
		
	}
	public ArrayList<Product> getProductList(String pid2) {
		// TODO Auto-generated method stub
		ArrayList<Product> pInfo=new ArrayList<Product>();
		try{
			Connection con = DBUtil.getDBConnection();
			PreparedStatement pt=con.prepareStatement("select * from tbl_stock");
			
			
			ResultSet rs=pt.executeQuery();
			Product p;
			while(rs.next())
			{
				
					String pID=rs.getString(1);
					String pName=rs.getString(2);
					int quality=rs.getInt(3);
					double price=rs.getDouble(4);
					int reOrder=rs.getInt(5);
					p=new Product();
					p.setProductID(pID);
					p.setProductName(pName);
					p.setQuantityOnHand(quality);
					p.setProductUnitPrice(price);
					p.setReorderLevel(reOrder);
					pInfo.add(p);
				
			}
			rs.close();
			pt.close();
			
			return pInfo;
			
		
	}catch(Exception g)
		{
		g.printStackTrace();
		return null;
		}
	}
	public String deleteStock(String pid) {
		// TODO Auto-generated method stub
		try{
			Connection con = DBUtil.getDBConnection();
			String data = "delete from tbl_stock where PRODUCT_ID=?";
			 PreparedStatement pt = con.prepareStatement(data);
			 pt.setString(1, pid);
			 int i=pt.executeUpdate();
			 if(i!=0)
			 {
				 return "Delete successfully";	
			 }
			 else
			 {
				 return "not found";
			 }
			 
			}
			catch(Exception g)
			{
				g.printStackTrace();
				return "can't be Delete!!!!";
			}
	}
	
	public String updateStock(String product_id, int quantity_Sold) {
		// TODO Auto-generated method stub
		try{
			int quantity=0;
			Connection con = DBUtil.getDBConnection();
			PreparedStatement pt=con.prepareStatement("select * from tbl_stock where PRODUCT_ID=?");
			pt.setString(1, product_id);
			ResultSet rs=pt.executeQuery();
			while(rs.next())
			{
				String pID=rs.getString(1);
				if(product_id.equals(pID))
				{
					quantity=rs.getInt(3);
					quantity=quantity-quantity_Sold;
				}
			
			}
			PreparedStatement pt1=con.prepareStatement("insert into tbl_stock values(?)");
			pt1.setInt(1,quantity_Sold);
			System.out.println("Get quantity");
			pt1.executeUpdate("UPDATE tbl_stock  SET QUALITY_ON_HAND='"+quantity+"' WHERE PRODUCT_ID='"+product_id+"'");
		}
		catch(Exception g)
		{
			g.printStackTrace();
			return "Not Update!!!!";
		}
		
		return "Sales Completed";	
	}
}
