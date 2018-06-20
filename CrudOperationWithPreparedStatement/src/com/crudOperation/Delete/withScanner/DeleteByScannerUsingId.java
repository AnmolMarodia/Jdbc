package com.crudOperation.Delete.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;

public class DeleteByScannerUsingId
{

	public static void main(String[] args)
	{
		Connection conn=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
			
			PreparedStatement pt=null;;
			
			String n=null;
			int id=0;
			do
			{
				System.out.println("Enter the id you want to delete");
				id=sc.nextInt();
				
				pt=conn.prepareStatement(String.format("delete from student where sid=%d",id));
				int count=pt.executeUpdate();
				System.out.println(count+" record deleted");
				
				System.out.println("do you want to delete more rows yes/no");
				n=sc.next();
				
			}while(n.equalsIgnoreCase("yes"));
			
			System.out.println("Thank You");
			
		} catch (ClassNotFoundException | SQLException e) {
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
