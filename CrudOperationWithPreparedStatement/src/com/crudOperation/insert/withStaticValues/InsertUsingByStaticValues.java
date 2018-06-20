package com.crudOperation.insert.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsingByStaticValues 
{

	public static void main(String[] args)
	{
		Connection conn=null;
	     try
	     {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
			PreparedStatement st=conn.prepareStatement("insert into Company values(101,'TCS','bangalore')");
			
			int count=st.executeUpdate();
			System.out.println(count+" row inserted");
			
		 }
	     catch (ClassNotFoundException | SQLException e)
	     {
			e.printStackTrace();
		 }	
	}

}
