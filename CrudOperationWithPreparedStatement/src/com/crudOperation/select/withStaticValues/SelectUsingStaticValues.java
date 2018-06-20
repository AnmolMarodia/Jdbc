package com.crudOperation.select.withStaticValues;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class SelectUsingStaticValues {

	public static void main(String[] args)
	{
		Connection conn=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn=DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee?user=root&password=root");
			
			PreparedStatement st=conn.prepareStatement("select * from company");
			ResultSet rs=st.executeQuery();
			System.out.println("<------The Details are------>");
			while(rs.next())
			{
				System.out.println(rs.getInt(1)+" "+rs.getString(2)+" "+rs.getString(3));
			}
			
		} catch (ClassNotFoundException | SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
