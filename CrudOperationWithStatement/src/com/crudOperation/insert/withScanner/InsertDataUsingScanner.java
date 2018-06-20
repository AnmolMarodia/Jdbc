package com.crudOperation.insert.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class InsertDataUsingScanner {

	public static void main(String[] args)
	{
		Connection conn=null;
		Scanner sc=new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
			Statement st=conn.createStatement();
			
			String n=null;
			do
			{
				
				System.out.println("Enter the Company id");
				int Cid=sc.nextInt();
				
				System.out.println("Enter the Company name");
				String Cname=sc.next();
				
				System.out.println("Enter the Company place");
				String Cplace=sc.next();
				
				int count=st.executeUpdate(String.format("insert into Company values(%d,'%s','%s')", Cid,Cname,Cplace));
						
				System.out.println(count+" row inserted");

				System.out.println("Do you want to insert more row yes/no");
				n=sc.next();
			}while(n.equalsIgnoreCase("yes"));
			
			System.out.println("rows inserted");
			
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
