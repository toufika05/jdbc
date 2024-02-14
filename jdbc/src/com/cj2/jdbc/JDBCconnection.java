package com.cj2.jdbc;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;
import java.util.Arrays;

public class JDBCconnection {

	public static void main(String[] args) {
	      
		Connection connection=null;
		
		try {
			//1.load and register the driver
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("1.Driver has been loaded succesfully");
			
			///2.Establish the connection
			 connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase?user=root&password=root");
			System.out.println("2.Establish the connection");
        
		     Statement statement = connection.createStatement();
		     System.out.println("3.statement has created");
		     
		     //disable the auto connection mode
		     connection.setAutoCommit(false);
		     
		     statement.execute("update student set marks=marks+10 where id=102");
		     System.out.println( "query1 executed");
		     
		     statement.execute("update student set marks=marks-10  where id=Tom");
		     System.out.println( "query2  executed");
		     
		    connection.commit();
		    System.out.println("data commited");
		    
		} catch (ClassNotFoundException | SQLException e) {
			   try {
				connection.rollback();
				System.out.println("roll back");
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			e.printStackTrace();
		} 
		finally {
			try {
				connection.close();
				System.out.println("connection has been closed");
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		
		}
	}




































	
		
      

