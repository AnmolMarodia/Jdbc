package com.crudOperation.Delete.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class DeleteByScannerUsingName
{
	public static void main(String[] args)
	{
		Connection conn=null;
		Scanner sc=new Scanner(System.in);
		try
		{
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
			
			Statement st=conn.createStatement();
		    
		    String n=null,name=null;
		      do
		      {
		    	System.out.println("Enter the name you want to delete"); 
		    	name=sc.next();
		    	
		    	String sql=String.format("delete from company where Cname='%s'",name.toUpperCase());
		    	System.out.println(sql);
		    	
		    	int count=st.executeUpdate(sql);
		    	System.out.println(count+" row deleted");
		    	
		    	System.out.println("Do you want to delete more yes/no");
		    	n=sc.next();
		      }while(n.equalsIgnoreCase("yes"));
		      
		      System.out.println("Thank You");
		} 
		catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally
		{
			sc.close();
			try {
				conn.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
}
