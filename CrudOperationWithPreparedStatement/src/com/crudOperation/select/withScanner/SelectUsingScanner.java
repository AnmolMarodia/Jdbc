package com.crudOperation.select.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;

public class SelectUsingScanner {

	public static void main(String[] args)
	{
		Connection conn=null;
		Scanner sc=new Scanner(System.in);
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
		
		PreparedStatement pt=null;
		String n=null,tableName=null;
		do
		{
			System.out.println("Enter the tableName to see the data");
			tableName=sc.next();
			
			pt=conn.prepareStatement("select * from "+tableName);
			ResultSet rs =pt.executeQuery();
			System.out.println("------The details are--------");
			while(rs.next())
			{
			System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
			System.out.println("Do you want to continue yes/no");
			n=sc.next();
		}while(n.equalsIgnoreCase("yes"));
		System.out.println("Thank you");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  
	}

}
