package com.wipro.sales.util;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBUtil {
	
	public static Connection getDBConnection(){
		Connection con = null;	
			try{
				Class.forName("oracle.jdbc.driver.OracleDriver");
				con=DriverManager.getConnection(  
						"jdbc:oracle:thin:@localhost:1521:xe","system","tyagi123");
			
				return con;
			}catch(Exception e){
				return con;
			}
			
			
		}

}
