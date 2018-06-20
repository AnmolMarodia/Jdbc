package com.crudOperation.insert.withPlaceholder;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class InsertUsingPlaceholderWithoutScanner {

	public static void main(String[] args)
	{
		Connection conn=null;
		PreparedStatement pt=null;
	   try {
		Class.forName("com.mysql.jdbc.Driver");
		conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
		
		pt=conn.prepareStatement("insert into Student values(?,?,?)");
		
		pt.setInt(1, 101);
		pt.setString(2, "Anmol");
		pt.setString(3, "bangalore");
		
		int count=pt.executeUpdate();
		System.out.println(count+" record inserted");
		
	} catch (ClassNotFoundException | SQLException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}

}
