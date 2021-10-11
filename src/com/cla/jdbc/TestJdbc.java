package com.cla.jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

public class TestJdbc {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		String jdbcurl="jdbc:mysql://localhost:3306/db_book_store?useSSL=false&serverTimezone=UTC";
		String user="bookdetail";
		String password="bookdetail";
		
		try {
			System.out.println("Connecting to database:  "+jdbcurl);
			Connection conn=DriverManager.getConnection(jdbcurl,user,password);
			System.out.println("Connection Successful");
	   }
		catch(Exception e) {
			e.printStackTrace();
		}
		}

}
