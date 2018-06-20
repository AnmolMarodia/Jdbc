package com.crudOperation.insert.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class InsertUsingByStaticValues 
{

	public static void main(String[] args)
	{
		Connection conn=null;
	     try
	     {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
			Statement st=conn.createStatement();
			
			int count=st.executeUpdate("insert into Company values(101,'TCS','bangalore')");
			System.out.println(count+" row inserted");
			
		 }
	     catch (ClassNotFoundException | SQLException e)
	     {
			e.printStackTrace();
		 }	
	}

}
