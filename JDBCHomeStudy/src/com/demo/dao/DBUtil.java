package com.demo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBUtil {
	
	static Connection con;
	
	public static Connection getMyConnection(){
		if(con==null)
		{
			try {
				Class.forName("com.mysql.cj.jdbc.Driver()");
				con= DriverManager.getConnection("jdbc:mysql://localhost/3306/mukund", "root", "root");
			} catch (Exception e) {
				
				e.printStackTrace();
			}
		}
		return con;
	}
	
	public static void getCloseMyConnection()
	{
		try {
			con.close();
		} catch (SQLException e) {
			
			e.printStackTrace();
		}
	}

}
