package com.bookstore.model;


import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.sql.Statement;

public class DAOImp 
{

	private static String driver = "com.mysql.cj.jdbc.Driver";
	private static String dbUrl = "jdbc:mysql://localhost:3306/bookstore";
	private static String dbUsername = "root";
	private static String dbPassword = "12345";
	private static Connection conn = null;
	private static Statement stm = null;
	private static ResultSet rs = null;
	private static String sql = null;
	private ResultSetMetaData rsmd = null;
	
	private PreparedStatement pStatement =null;
	
	



	public DAOImp() {
		getConnection();
	}



	public void getConnection() {
		
		try {
			Class.forName(driver);
			conn = DriverManager.getConnection(dbUrl,dbUsername,dbPassword);
			stm = conn.createStatement();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public Connection getConn()	{
		return conn;
		
	}
	
	
	public int insertData(PreparedStatement pstm)
	{
		//sql = "INSERT into register(name, age, userName,password, email,phone,address) VALUES(?,?,?,?,?,?,?)";
		int result = 0;
		
		try {
			
			result=pstm.executeUpdate();
			
//			pStatement.setString(1, name);
//			pStatement.setString(2, age);
//			pStatement.setString(3, userName);
//			pStatement.setString(4, password);
//			pStatement.setString(5, email);
//			pStatement.setString(6, phone);
//			pStatement.setString(7, address);
//			System.out.println("Inserted rows : " + pStatement.executeUpdate());
			System.out.println("Inserted rows : " + result);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result; 
	}
	
	
	public ResultSet selectData(PreparedStatement psmt)
	{
		//sql = "SELECT name, username, password FROM register";
		
		try {
			
			 rs=psmt.executeQuery();

			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return rs;
	}

	public int deleteData(PreparedStatement pstm)
	{
		//sql = "DELETE FROM register where id = ?";
		int result = 0;
		try {
			
//			pStatement = conn.prepareStatement(sql);	
//			pStatement.setInt(1, id);
			result= pstm.executeUpdate();
			System.out.println("Deleted rows : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	public int updateData(PreparedStatement psmt)
	{
		//sql = "UPDATE register SET password = ? where id = ?";
		int result = 0;
		try {
			
			//pStatement = conn.prepareStatement(sql);
			//pStatement.setString(1, pswd);
			//pStatement.setInt(2, id);
			result = psmt.executeUpdate();
			
			System.out.println("Updated rows : " + result);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return result;
		
	}
	
	
	public void close() {
		String message = "Closed";
	    try {
	      stm.close();
	      conn.close();
	      
	    } catch (Exception e) {
	      message = e.getMessage();
	    }
	 
	  }
	
	
	
	
}
