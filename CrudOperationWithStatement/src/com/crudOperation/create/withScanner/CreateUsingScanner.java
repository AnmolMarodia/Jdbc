package com.crudOperation.create.withScanner;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Scanner;

public class CreateUsingScanner {

	public static void main(String[] args) {
		Connection conn = null;
		Statement st = null;
		Scanner sc = new Scanner(System.in);
		try {
			Class.forName("com.mysql.jdbc.Driver");
			conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/j2ee", "root", "root");
			st = conn.createStatement();

			
			System.out.println("Enter The Table Name");
			String table_name = sc.next();

			// System.out.println("Enter The No Of columns");
			String col_name1 = null, dataType1 = null;

			System.out.println("Enter the column name");
			col_name1 = sc.next();

			System.out.println("Enter the DataType varchar or int");
			dataType1 = sc.next();

			System.out.println("Enter The Size");
			int size1 = sc.nextInt();

			System.out.println("Enter the column name");
			String col_name2 = sc.next();

			System.out.println("Enter the DataType varchar or int");
			String dataType2 = sc.next();

			System.out.println("Enter The Size");
			int size2 = sc.nextInt();

			String sql = "create table " + table_name + "(" + col_name1 + " " + dataType1 + "(" + size1 + "),"
					+ col_name2 + " " + dataType2 + "(" + size2 + "))";
			System.out.println(sql);
			int count = st.executeUpdate(sql);

			System.out.println(count + " table created");
		}

		catch (ClassNotFoundException | SQLException e) {
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
