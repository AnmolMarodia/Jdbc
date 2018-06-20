package com.crudOperation.Delete.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;


public class DeleteByUsingStaticValues {

	public static void main(String[] args) 
	{
		Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
	    
	    PreparedStatement pt=conn.prepareStatement("delete from company where Cname='TCS'");
	    
	    int count=pt.executeUpdate();
	    System.out.println(count+" row deleted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

}
