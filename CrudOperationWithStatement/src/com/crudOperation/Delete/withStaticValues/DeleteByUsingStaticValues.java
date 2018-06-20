package com.crudOperation.Delete.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class DeleteByUsingStaticValues {

	public static void main(String[] args) 
	{
		Connection conn=null;
	try {
		Class.forName("com.mysql.jdbc.Driver");
	    conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
	    
	    Statement st=conn.createStatement();
	    
	    int count=st.executeUpdate("delete from company where Cname='TCS'");
	    System.out.println(count+" row deleted");
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}	
	}

}
