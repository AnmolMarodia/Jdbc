package com.crudOperation.insert.withPlaceholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class InsertUsingPlaceholderWithScanner {

	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement pt=null;
		Scanner sc=new Scanner(System.in);
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
		
		pt=conn.prepareStatement("insert into Student values(?,?,?)");
		String n=null,sname=null,splace=null;
		int sid=0;
		do
		{
			System.out.println("Enter the student Id");
			sid=sc.nextInt();
			
			System.out.println("Enter the student Name");
			sname=sc.next();
			
			System.out.println("Enter the student place");
			splace=sc.next();
			
			pt.setInt(1, sid);
			pt.setString(2, sname);
			pt.setString(3, splace);
			
			int count=pt.executeUpdate();
			System.out.println(count+" record inserted");
				
			System.out.println("Do you want to insert more records yes/no");
			n=sc.next();
		}while(n.equalsIgnoreCase("yes"));
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	   System.out.println("Thank You");
	}

}
