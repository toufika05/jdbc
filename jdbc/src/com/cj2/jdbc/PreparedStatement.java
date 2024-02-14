package com.cj2.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class PreparedStatement {

	public static void main(String[] args) {
		
		Connection connection=null;
		try {
			//1.load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1. Driver has been loaded succesfully");
			
			///2.Establish the connection
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase?user=root&password=root");
			System.out.println("2.Establish the connection");
		       
		
		
			
			
			
			
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		finally {
			try {
				connection.close();
				System.out.println("connection has been closed      ");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}

	}

	public void setString(int i, String string) {
		// TODO Auto-generated method stub
		
	}



}
