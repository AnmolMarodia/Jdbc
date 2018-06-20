package com.crudOperation.insert.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingScanner {

	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement pt=null;
		Scanner sc=new Scanner(System.in);
	  try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
		
		String n=null,sname=null,splace=null;
		int sid=0;
		do
		{
			System.out.println("Enter the Id");
			sid=sc.nextInt();
			
			System.out.println("Enter the names");
			sname=sc.next();
			
            System.out.println("Enter the palce");
            splace=sc.next();
			pt=conn.prepareStatement(String.format("insert into student values(%d,'%s','%s')",sid,sname,splace));
			int count=pt.executeUpdate();
			System.out.println("Record inserted");
			
			System.out.println("Do you want to enter more records yes/no");
			n=sc.next();
		}while(n.equalsIgnoreCase("yes"));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	  System.out.println("Thank you");
	}

}
