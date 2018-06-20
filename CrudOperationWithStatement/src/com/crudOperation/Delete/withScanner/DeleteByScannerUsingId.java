package com.crudOperation.Delete.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
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
			
			Statement st=conn.createStatement();
			
			String n=null;
			int id=0;
			do
			{
				System.out.println("Enter the id you want to delete");
				id=sc.nextInt();
				
				int count=st.executeUpdate(String.format("delete from company where Cid=%d",id));
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
