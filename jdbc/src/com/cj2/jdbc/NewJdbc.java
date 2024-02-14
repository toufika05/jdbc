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

public class NewJdbc {
 
	public static void main(String[] args) {
       Connection connection=null;
        try {
			Class.forName("com.mysql.jdbc.Driver");
			System.out.println("load and register the driver");
			
			connection = DriverManager.getConnection("jdbc:mysql://localhost:3306/firstdatabase?user=root&password=root");
			System.out.println("establish the connection");
			
//			///insert a product record by jdbc program
//		   Statement statement = connection.createStatement();
//		   System.out.println("statement has been created");
//		

	     // statement.execute("insert into product values(100,'dress',1500.00)");
        // System.out.println("query has been executed");
		   
   
//		   ///feath all the product record from product table
//		     ResultSet resultSet= statement.executeQuery("select* from product");
//		     System.out.println("query has been executed");
//		     System.out.println("processing the result");
//		     
//		     while(resultSet.next()) {
//		     
//		     System.out.println(resultSet.getInt("id")+" "+resultSet.getString("name")+" " +resultSet.getDouble("price"));
//
//		     
//		     } System.out.println("no more record found");
		   
		   
//		   ///fetch a perticular record by id ..if id is not present then tell product is not available
//		   ResultSet resultSet= statement.executeQuery("select* from product where id=103");
//		   System.out.println("query has been executed");
//
//		   if(resultSet.next()) {
//
//		   System.out.println("product is available");
//
//		   } else {
//		   	 System.out.println("product is not available");
//		   }
		   
//		   Statement statement = connection.createStatement();
//		   System.out.println("statement has been created");
//		   
//		   statement.execute("update product set price=price-500 where id =104");
//		   System.out.println("update is successful");
		   
			Statement statement = connection.createStatement();
       	    System.out.println("statement has been created");
       	    
			/////6. 7. and 8.th answer
       	    
	      statement.addBatch("update product set price=(price*(10/100)+price)");
	      System.out.println("query1 added");
       	   
	      statement.addBatch("delete from product where id=100");
	      System.out.println("query2 added");
	      
	      statement.addBatch("delete from product where price>2000");
	      System.out.println("query1 added");
		    
	      int[] batch = statement.executeBatch();
	      System.out.println(Arrays.toString(batch));

		} catch (ClassNotFoundException |  SQLException e) {
			
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
