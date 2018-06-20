package com.crudOperation.create.withStaticVAlues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.sql.Statement;


public class CreateUsingStaticVAlues
{

	public static void main(String[] args) 
	{
		Connection conn=null;
		PreparedStatement pt=null;
		  try 
		  {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
			
			pt=conn.prepareStatement("create table User(Uid varchar(20),Uname varchar(20),Uplace varchar(20))");
			
			int count=pt.executeUpdate();
			
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
