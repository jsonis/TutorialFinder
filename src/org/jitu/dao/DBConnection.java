package org.jitu.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

public class DBConnection {
		
	private static Connection conn = null;
	
	private DBConnection(){
	}

	public static Connection getInstance(){
		if(conn ==null){
			return createDBConnection();
		}else
			return conn;
		
	}
	
	private static Connection createDBConnection(){
		Properties props = new Properties();
		props.put("user", "root");
		props.put("password", "password");
		
		
		try {
			Class.forName("com.mysql.jdbc.Driver").newInstance();
			conn   = DriverManager.getConnection("jdbc:mysql://localhost:3306/world",props);
		} catch (InstantiationException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return conn;
		
	}
	
	
}
