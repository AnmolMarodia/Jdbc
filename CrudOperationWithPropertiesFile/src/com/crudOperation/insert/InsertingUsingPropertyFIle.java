package com.crudOperation.insert;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

public class InsertingUsingPropertyFIle {

	public static void main(String[] args)
	{
	 try
	 {
		FileInputStream fw=new FileInputStream("db1.properties");
		Properties pro=new Properties();
		pro.load(fw);
		
		String driver=pro.getProperty("driver");
		String url=pro.getProperty("url");
		
		Class.forName(driver);
		Connection conn=DriverManager.getConnection(url, pro);
		
		Statement st=conn.createStatement();
		int count=st.executeUpdate("insert into student values(101,'Rajni','delhi')");
		
		System.out.println("record inserted");
	 }
	 catch (IOException | ClassNotFoundException | SQLException  e) 
	 {
		// TODO Auto-generated catch block
		e.printStackTrace();
	 }
		
	}

}
