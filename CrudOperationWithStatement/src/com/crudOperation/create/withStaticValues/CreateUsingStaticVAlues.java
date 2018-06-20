package com.crudOperation.create.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateUsingStaticVAlues
{

	public static void main(String[] args) 
	{
		Connection conn=null;
		  try 
		  {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
			
			Statement st=conn.createStatement();
			int count=st.executeUpdate("create table Company(Cid varchar(20),Cname varchar(20),Cplace varchar(20))");
			
			if(count==0)
				System.out.println("table created");
			else
				System.out.println("table not created");
	      } 
		  catch (ClassNotFoundException | SQLException e) 
		  {
				e.printStackTrace();
	      }	
     }

}
