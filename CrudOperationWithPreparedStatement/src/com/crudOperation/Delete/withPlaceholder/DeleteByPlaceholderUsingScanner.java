package com.crudOperation.Delete.withPlaceholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteByPlaceholderUsingScanner {

	public static void main(String[] args) 
	{
		Connection conn=null;
		PreparedStatement pt=null;
		Scanner sc=new Scanner(System.in);
	try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
		
		String n=null;
		int sid=0;
	  do
		{
			pt=conn.prepareStatement("delete from student where sid =?");
			
			System.out.println("Enter the id to be deleted");
			sid=sc.nextInt();
			pt.setInt(1, sid);
			int count = pt.executeUpdate();
		    System.out.println(count+" row deleted"); 
			
		    System.out.println("Do you want to delete more record through Id yes/no");
		    n= sc.next();
		    
		}while(n.equalsIgnoreCase("yes"));
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	  System.out.println("Thank You");
	}

}
