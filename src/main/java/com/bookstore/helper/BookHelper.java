package com.bookstore.helper;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.bookstore.entity.Book;
import com.bookstore.model.DAOImp;
import com.mysql.cj.protocol.x.ContinuousOutputStream;

import com.bookstore.service.AdminImp;

public class BookHelper implements AdminImp {
	DAOImp daoImp = new DAOImp();
	Connection conn = daoImp.getConn();
	Book book = new Book();
	String sql = null;
	String result = "";
	@Override
	public void display() {
		sql = "SELECT * FROM book";
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			ResultSet rst = daoImp.selectData(psmt);
			while(rst.next()) {
				int id = rst.getInt("idBook");
				book.setCategory(rst.getString("category"));
				book.setTitle(rst.getString("title"));
				book.setAuthor(rst.getString("author"));
				book.setISBN( rst.getString("ISBN"));
				book.setPublisher( rst.getString("publisher"));
				book.setEditionNumber(rst.getString("editionNumber"));
				book.setPrice( rst.getDouble("price"));
			    System.out.println(id +" "+book.toString());
				//				System.out.println("Category"+ " " +" Title" + " " + "Author" + " " + "ISBN" + " " +"Publiher" + " "
//						+ "Edition"+ " " + "Price");
//				System.out.println(category+ " " + title + " " + author + " " + ISBN + " " +publiher + " "
//				+ edition+ " " + price);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

	@Override
	public int insert(Book book) {
		// TODO Auto-generated method stub
	
		sql = "INSERT INTO book(category, title, author, ISBN, publisher, editionNumber, price) VALUES (?,?,?,?,?,?,?)";
		int insertRow= 0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setString(1, book.getCategory());
			psmt.setString(2, book.getTitle());
			psmt.setString(3, book.getAuthor());
			psmt.setString(4, book.getISBN());
			psmt.setString(5, book.getPublisher());
			psmt.setString(6, book.getEditionNumber());
			psmt.setDouble(7, book.getPrice());
			insertRow=daoImp.insertData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return insertRow;
	
	}

	@Override
	public int delete(int id) {
		sql = "DELETE FROM book WHERE idBook = ? ";
		int deleteRow=0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
			psmt.setInt(1, id);
			deleteRow=daoImp.deleteData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return deleteRow;
		
		
	}

	@Override
	public int edit(int id, Double price) {
		sql= "UPDATE book SET price= ? WHERE idBook = ?";
		int updateRow=0;
		try {
			PreparedStatement psmt = conn.prepareStatement(sql);
	
			psmt.setDouble(1, price);
			psmt.setInt(2, id);
		    updateRow = daoImp.updateData(psmt);
//			psmt.setString(2, category);
//			psmt.setString(3, book.getAuthor());
//			psmt.setString(4, book.getISBN());
//			psmt.setString(5, book.getPublisher());
//			psmt.setString(6, book.getEditionNumber());
//			psmt.setString(7, book.getPrice());
//			updateRow=daoImp.updateData(psmt);
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return updateRow;
		
	}

	@Override
	public void purchaseHistory() {
		// TODO Auto-generated method stub
		
	}



}
