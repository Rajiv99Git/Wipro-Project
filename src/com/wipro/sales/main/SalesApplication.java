package com.wipro.sales.main;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.Year;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.Iterator;
import java.util.Scanner;
import com.wipro.sales.bean.Product;
import com.wipro.sales.bean.Sales;
import com.wipro.sales.bean.SalesReport;
import com.wipro.sales.service.Administrator;
public class SalesApplication {

	public static void main(String[] args) throws ParseException {
		// TODO Auto-generated method stub
		
		int con;
		Scanner in=new Scanner(System.in);
		do {
				System.out.println("Main=Menu");
				System.out.println("prees 1 for Insert Stock :");
				System.out.println("prees 2 for Delete Stock :");
				System.out.println("prees 3 for Insert Sales  :");
				System.out.println("press 4 for View Sales Report  :");
				System.out.println("Press 5 for Close  :");
				con=in.nextInt();
				switch(con)
				{
				case 1:
				{
					System.out.println("Enter ProductName :");
					String pname=in.next();
					System.out.println("Enter quantityOnHand  :");
					int quantityOnHand=in.nextInt();
					System.out.println("Enter productUnitPrice :");
					double productUnitPrice=in.nextDouble();
					System.out.println("Enter reorderLevel  :");
					int reorderLevel=in.nextInt();
					Product p=new Product(pname, quantityOnHand, productUnitPrice, reorderLevel);
					Administrator admin=new Administrator();
					String pid=admin.insertStockStock(p);
					ArrayList<Product> al=admin.getinfo(pid);
					String title=String.format("%-16.16s %-20.20s %-20.20s %-20.20s %-20.20s","ProductID","ProductName","Quantity_On_Hand","Product_Unit_Price","Reorder_Level");
					System.out.println(title);
					System.out.println("----------------------------------------------------------------------------------------------------------");
					 Iterator itr=al.iterator();  
				        while(itr.hasNext()){  
				            Product pd=(Product)itr.next();
				            System.out.println(String.format("%-16s %-20s %-20d %-20f %-20d",pd.getProductID(),pd.getProductName(),pd.getQuantityOnHand(),pd.getProductUnitPrice(),pd.getReorderLevel()));
				        }  	
					
					System.out.println("-----------------------------------------------------------------------------------------------------------");
					break;
				}
				case 2:
				{
					System.out.println("Enter product ID tO delete stock data!!");
					String pid=in.next();
					Administrator admin=new Administrator();
					String dltInfo=admin.dltStock(pid);
					System.out.println(dltInfo);
					break;
				}
				case 3:
				{
					System.out.println("Enter Sales Date!!");
					String dt=in.next();
					Date date=new SimpleDateFormat("dd/MM/yyyy").parse(dt);  
					System.out.println(date);
					System.out.printf("Two-digit Year = %ty\n",date);
					
					System.out.println("Enter Product ID!!");
					String pid=in.next();
					System.out.println("Quantity Sold!!");
					int quantitySold=in.nextInt();
					
					System.out.println("Sales Price per unit!!");
					double salesPrice=in.nextDouble();
					Sales s=new Sales(date,pid,quantitySold,salesPrice);
					Administrator admin=new Administrator();
					String sales=admin.insertSales(s);
					System.out.println(sales);
					
				}
				case 4:
				{
					Administrator admin=new Administrator();
					ArrayList<SalesReport> sr=admin.getSalesReport();
					String title=String.format("%-16.16s %-20.20s %-20.20s %-20.20s %-20.20s %-20.20s %-20.20s %-20.20s","Sales_ID","Sales_Date","Product_ID","Product_Name","Quantity_Sold","Product_Unit_Price","Sales_Price_Per_Unit","Profit_Amount");
					System.out.println(title);
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					 Iterator itr=sr.iterator();  
				        while(itr.hasNext()){  
				        	SalesReport pd=(SalesReport)itr.next();
				            System.out.println(String.format("%-16s %-20tD %-20s %-20s %-20d %-20f %-20f %-20f",pd.getSalesID(),pd.getSalesDate(),pd.getProductID() ,pd.getProductName(),pd.getQuantitySales(),pd.getProductUnitPrice(),pd.getSalesPricePerUnit(),pd.getProfitAmount()));
				        }  	
					
					System.out.println("-----------------------------------------------------------------------------------------------------------------------------------------------------------------------");
					break;
					
				}
				case 5:
				{
					System.out.println("Thanks to used Inventory and Sales System!!");
					System.exit(0);
				}
				default:
				{
					System.out.println("Thanks!!");
				}

				}

		}while(con<=4);
	}	
}