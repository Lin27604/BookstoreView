package com.bookstore.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import javax.swing.table.TableStringConverter;

import com.bookstore.entity.UserAccount;
import com.bookstore.model.DAOImp;

public class RegisterHelper {

	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();

	public String isPwdValid(String userName) {

		String sql = "SELECT password, usertype FROM register where username = ?";
		String password = null;
		String type = null;
		UserAccount uAccount=null;

		try {

			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userName);
			ResultSet rst = daoImp.selectData(psmt);
			if (rst.next()) {
				password = rst.getString(1);
				type = rst.getString(2);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return password;

	}

	
	
	
	public boolean registerAccount(UserAccount userAccount) {
		String  sql= "INSERT into register(name, age, username,password, email,phone) VALUES(?,?,?,?,?,?)";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, userAccount.getName());
			psmt.setString(2, userAccount.getAge());
			psmt.setString(3, userAccount.getUserName());
			psmt.setString(4, userAccount.getPassword());
			psmt.setString(5, userAccount.getEmail());
			psmt.setString(6, userAccount.getPhone());
			
			
			if(daoImp.insertData(psmt)>0)
				return true;
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return false;
		
	}

}
